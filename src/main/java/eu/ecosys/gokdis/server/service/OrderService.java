package eu.ecosys.gokdis.server.service;

import org.springframework.stereotype.Service;

import eu.ecosys.gokdis.server.entity.CustomerOrder;
import eu.ecosys.gokdis.server.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<CustomerOrder> findAll() {
        return orderRepository.findAll();
    }

    public CustomerOrder findById(String id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public CustomerOrder updateById(String id, CustomerOrder order) {
        return orderRepository.updateById(id, order);
    }

    public CustomerOrder saveOrderById(CustomerOrder order) {
        return orderRepository.save(new CustomerOrder(
                order.id(), order.personEmail(),
                order.productId(), order.description(),
                order.quantity(), order.time()));
    }

    public void deleteById(String id) {
        orderRepository.delete(orderRepository.findById(id).orElseThrow());
    }
}