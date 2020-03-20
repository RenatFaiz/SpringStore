package cosmonaut.controller;

import cosmonaut.entity.Product;
import cosmonaut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {


    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/shop")
    public String toShop(Model model) {
//        List<Product> allProducts = new ArrayList<>(5);
//        allProducts.add(new Product(1L, "Milk", 34));
//        allProducts.add(new Product(2L, "Bread", 41));
        model.addAttribute("products", productService.getAllProducts());
        return "shop";
    }
}
