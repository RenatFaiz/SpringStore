package cosmonaut.service;

import cosmonaut.entity.Order;
import cosmonaut.entity.OrderItem;
import cosmonaut.entity.User;
import cosmonaut.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        //order.setOrderItems(new ArrayList<>());
        order.setOrderItems(orderItems);
        order.setUser(user);
        //?
        return orderRepository.save(order);
    }

    // TODO
    public void deleteOrderById() {
    }


}
