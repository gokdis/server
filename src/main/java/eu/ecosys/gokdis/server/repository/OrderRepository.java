package eu.ecosys.gokdis.server.repository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import eu.ecosys.gokdis.server.entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CustomerOrder, UUID> {
    Optional<CustomerOrder> findById(String id);

    default CustomerOrder updateById(String id, CustomerOrder updatedOrder) {
        return findById(id).map(existingOrder -> {
            CustomerOrder updatedRecord = new CustomerOrder(
                    existingOrder.id(),
                    updatedOrder.personEmail() != null ? updatedOrder.personEmail() : existingOrder.personEmail(),
                    updatedOrder.productId() != null ? updatedOrder.productId() : existingOrder.productId(),
                    updatedOrder.description() != null ? updatedOrder.description() : existingOrder.description(),
                    updatedOrder.quantity(),
                    updatedOrder.time() != null ? updatedOrder.time() : existingOrder.time()

            );
            return save(updatedRecord);
        }).orElseThrow(() -> new NoSuchElementException("Order not found with mac: " + id));
    }
}