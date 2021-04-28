package pl.coderslab.charity.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CurrentUser;
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

//        if(!user.getPassword().equals(user.getPasswordConfirm())) {
//
//        }


        this.userService.saveUser(user);


        return "homePage";
    }

    @GetMapping("/createAdmin")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setUsername("admin");
        user.setEmail("admin@gmail.com");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }

    @GetMapping("/logged")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Test " + entityUser.getUsername() + " " + entityUser.getPassword();
    }


}
