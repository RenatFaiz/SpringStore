package cosmonaut.controller;

import cosmonaut.entity.Product;
import cosmonaut.entity.User;
import cosmonaut.repository.UserRepository;
import cosmonaut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    public String toHomepage() {
        return "index";
    }

    @RequestMapping("/users")
    public String showAllUsers(Model model, Pageable pageable) {
        model.addAttribute("users", userRepository.findAll(pageable));
        return "user";
    }

    @GetMapping("/login")
    public String toLoginPage() {
        return "login";
    }
}
