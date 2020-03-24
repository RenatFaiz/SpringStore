package cosmonaut.service;

import cosmonaut.entity.Order;
import cosmonaut.entity.OrderItem;
import cosmonaut.entity.User;
import cosmonaut.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // удалить
    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public Order createOrderFromItems(User user, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setOrderItems(new ArrayList<>());
        order.setUser(user);
        orderItems.stream().forEach(orderItem -> {
            order.getOrderItems().add(orderItem);
            orderItem.setOrder(order);
        });
        orderItems.clear();
        return orderRepository.save(order);
    }

    // getOne() ?
    public Order getOrderById(Long id) {
        return orderRepository.getOne(id);
    }

    public List<Order> getOrderByUsername(String username) {
        return orderRepository.findAllByUsername(username);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    // TODO
    public void deleteOrderById() {
    }


}