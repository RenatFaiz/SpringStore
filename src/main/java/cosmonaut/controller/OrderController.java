package cosmonaut.controller;

import cosmonaut.entity.Order;
import cosmonaut.entity.User;
import cosmonaut.service.OrderService;
import cosmonaut.service.UserService;
import cosmonaut.util.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCart cart;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public String showOrders(Model model, Principal principal) {
        model.addAttribute("orders",
                orderService.getOrders());
        model.addAttribute("user",
                userService.findByUsername(principal.getName()));
        return "orders";
    }

    @GetMapping("/order-details/{id}")
    public String toOrderDetails(Model model, @PathVariable("id") Long id) {
        Order selectedOrder = orderService.getOrderById(id);
        model.addAttribute("selectedOrder", selectedOrder);
        return "order-details";
    }

    @GetMapping("/create_order")
    public String createOrder(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Order orderFromItems = orderService.createOrderFromItems(user, cart.getOrderItems());
        return "redirect:order-details/" + orderFromItems.getId();
    }
}