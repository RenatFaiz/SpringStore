package cosmonaut.controller;

import cosmonaut.util.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/cart")
public class CartController {

    private ShoppingCart cart;

    @Autowired
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @GetMapping("")
    public String showCart(Model model) {
        model.addAttribute("orderItems", cart.getOrderItems());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id,
                            @RequestParam(value = "topage", defaultValue = "shop",
                                    required = false) String query) {
        cart.addProductById(id);
        if (query.equals("stayonpage")) {
            return "redirect:/details/{id}";
        }
        return "redirect:/" + query;
    }
}
