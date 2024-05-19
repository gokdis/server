package eu.ecosys.gokdis.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ecosys.gokdis.server.entity.CustomerOrder;
import eu.ecosys.gokdis.server.service.OrderService;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping(value = "/order")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public Iterable<CustomerOrder> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/order/{id}")
    @PreAuthorize("hasAnyRole('MOD', 'ADMIN')")
    public CustomerOrder findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping(value = "/order")
    @PreAuthorize("hasRole('ADMIN')")
    public CustomerOrder saveOrder(Authentication authentication, @RequestBody CustomerOrder order) {
        return service.saveOrder(authentication, order);
    }

    @DeleteMapping(value = "/order/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}