package eu.ecosys.gokdis.server.Repos;

import org.springframework.data.repository.CrudRepository;
import eu.ecosys.gokdis.server.Order;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
    Optional<Order> findById(String id);

    default Order updateById(String id, Order updatedOrder) {
        return findById(id).map(existingOrder -> {
            Order updatedRecord = new Order(
                    existingOrder.id(),
                    updatedOrder.personId() != null ? updatedOrder.personId() : existingOrder.personId(),
                    updatedOrder.productId() != null ? updatedOrder.productId() : existingOrder.productId(),
                    updatedOrder.description() != null ? updatedOrder.description() : existingOrder.description(),
                    updatedOrder.quantity(),
                    updatedOrder.time() != null ? updatedOrder.time() : existingOrder.time()

            );
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Order not found with mac: " + id));
    }
}