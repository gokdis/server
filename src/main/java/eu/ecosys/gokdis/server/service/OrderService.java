package eu.ecosys.gokdis.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.CustomerOrder;
import eu.ecosys.gokdis.server.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private AuthenticationService authenticationService;

    public Iterable<CustomerOrder> findAll() {
        return repository.findAll();
    }

    public CustomerOrder findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public CustomerOrder saveOrder(Authentication authentication, CustomerOrder order) {
        return repository.save(new CustomerOrder(
                order.id(), authenticationService.getUsername(authentication),
                order.productId(), order.description(),
                order.quantity(), order.time()));
    }

    public void delete(String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}