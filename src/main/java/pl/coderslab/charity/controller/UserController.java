package pl.coderslab.charity.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

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
    public String addUserPost(@Valid User user, BindingResult bindingResult) {

        if(!user.getPassword().equals(user.getPasswordConfirm())) {
            bindingResult.rejectValue("passwordConfirm","error.user","Hasło oraz potwierdzenie hasła nie są zgodne!");
            bindingResult.rejectValue("password","error.user","Hasło oraz potwierdzenie hasła nie są zgodne!");
        }

        boolean checkIfUserExist = userService.existsByName(user.getUsername());
        boolean checkIfEmailWasUsed = userService.existsByEmail(user.getEmail());

        if(checkIfUserExist) {
            bindingResult.rejectValue("username","error.user","Login jest zajęty!");
        }

        if(checkIfEmailWasUsed) {
            bindingResult.rejectValue("email","error.user","Adres email jest zajęty!");
        }

        if(bindingResult.hasErrors()) {
            return "register";
        }

        this.userService.saveUser(user);

        return "redirect:/login";
    }

}
