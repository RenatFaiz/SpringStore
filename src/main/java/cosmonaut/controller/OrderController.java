package cosmonaut.controller;

import cosmonaut.entity.Order;
import cosmonaut.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public String showOrders(Model model) {
        model.addAttribute("orders",
                orderService.getOrderRepository().findAll());
        return "orders";
    }
}
