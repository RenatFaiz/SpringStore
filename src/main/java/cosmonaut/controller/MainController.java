package cosmonaut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String toHomepage() {
        return "index";
    }

//    @GetMapping("/login")
//    public String toLoginPage() {
//        return "login";
//    }
}
