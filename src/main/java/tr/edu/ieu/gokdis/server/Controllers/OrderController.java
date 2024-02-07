package tr.edu.ieu.gokdis.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.ieu.gokdis.server.Order;
import tr.edu.ieu.gokdis.server.Repos.OrderRepository;

@RestController
@RequestMapping(value = "api/v1")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @GetMapping(value = "/order")
    public Iterable<Order> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/order/{id}")
    public Order findById(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping(value = "/order/{id}")
    public Order updateById(@PathVariable String id, @RequestBody Order order) {
        return repository.updateById(id,order);
    }

    @PostMapping(value = "/order")
    public Order saveOrderById(@RequestBody Order order) {
        return repository.save(new Order(
                order.id(),order.customerId(),
                order.productId(),order.description(),
                order.quantity(),order.time()));
    }

    @DeleteMapping(value = "/order/{id}")
    public void deleteById(@PathVariable String id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}
