package cosmonaut.service;

import cosmonaut.entity.Authority;
import cosmonaut.entity.Order;
import cosmonaut.entity.OrderItem;
import cosmonaut.entity.User;
import cosmonaut.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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

    public Order getOrderById(Long id) {
        return orderRepository.getOne(id);
    }

    public List<Order> getOrderByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getCustomOrders(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Authority> authorities = user.getAuthorities();
        for (Authority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_SELLER")) {
                return getAllOrders();
            }
        }
        return getOrderByUser(user);
    }


}
