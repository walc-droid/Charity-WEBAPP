package pl.coderslab.charity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String add(Model model) {
        model.addAttribute("user" , new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUserPost(User user) {
        this.userService.save(user);
        return "homePage";
    }
}
