package cosmonaut.controller;

import cosmonaut.entity.Product;
import cosmonaut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/shop")
    public String toShop(Model model, Pageable pageable) {
        model.addAttribute("products", productService.getAllProducts(pageable));
        return "shop";
    }

    @GetMapping("/details/{id}")
    public String toDetails(Model model, @PathVariable("id") Long id) {
        Product selectedProduct = productService.getProductById(id);
        model.addAttribute("selectedProduct", selectedProduct);
        return "details";
    }

    @GetMapping("/remove/{id}")
    public String deleteByProductId(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/shop";
    }
}
