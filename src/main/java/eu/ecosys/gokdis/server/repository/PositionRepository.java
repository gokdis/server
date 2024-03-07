package eu.ecosys.gokdis.server.repository;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.entity.Position;

public interface PositionRepository extends CrudRepository<Position, UUID> {
    default Position updateById(UUID id, Position updatedPosition) {
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