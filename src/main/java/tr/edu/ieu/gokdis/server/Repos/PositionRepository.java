package tr.edu.ieu.gokdis.server.Repos;

import org.springframework.data.repository.CrudRepository;
import tr.edu.ieu.gokdis.server.Position;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public interface PositionRepository extends CrudRepository<Position, UUID> {
    Optional<Position> findById(String id);

    default Position updateById(String id, Position updatedPosition) {
        return findById(id).map(existingOrder -> {
            Position updatedRecord = new Position(
                    existingOrder.id(),
                    updatedPosition.customerId() != null ? updatedPosition.customerId() : existingOrder.customerId(),
                    updatedPosition.x(),
                    updatedPosition.y(),
                    updatedPosition.time() != null ? updatedPosition.time() : existingOrder.time()

            );
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Position not found with mac: " + id));
    }
}
