package eu.ecosys.gokdis.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.entity.Order;
import eu.ecosys.gokdis.server.repository.OrderRepository;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    @Autowired
    private OrderRepository repository;

    @GetMapping(value = "/order")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<Order> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/order/{id}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Order findById(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/order/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Order updateById(@PathVariable String id, @RequestBody Order order) {
        return repository.updateById(id, order);
    }

    @PostMapping(value = "/order")
    @PreAuthorize("hasRole('ADMIN')")
    public Order saveOrderById(@RequestBody Order order) {
        return repository.save(new Order(
                order.id(), order.personId(),
                order.productId(), order.description(),
                order.quantity(), order.time()));
    }

    @DeleteMapping(value = "/order/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}