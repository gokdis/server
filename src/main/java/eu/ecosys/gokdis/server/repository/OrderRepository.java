package eu.ecosys.gokdis.server.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import eu.ecosys.gokdis.server.entity.CustomerOrder;

public interface OrderRepository extends CrudRepository<CustomerOrder, UUID> {
    Optional<CustomerOrder> findById(String id);
}