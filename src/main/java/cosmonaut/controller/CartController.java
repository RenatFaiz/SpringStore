package cosmonaut.controller;

import cosmonaut.service.OrderService;
import cosmonaut.util.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private ShoppingCart cart;

//    private ProductService productService;

    @Autowired
    private OrderService orderService;

//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @Autowired
//    public void setOrderService(OrderService orderService) {
//        this.orderService = orderService;
//    }

    @Autowired
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }



}
