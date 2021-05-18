package pl.coderslab.charity.app.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.app.user.AppUser;

import pl.coderslab.charity.app.user.AppUserService;


import javax.validation.Valid;


@Controller
public class RegistrationController {


    private final AppUserService userService;


    public RegistrationController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String add(Model model) {
        model.addAttribute("user" , new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String addUserPost(@Valid@ModelAttribute("user") AppUser appUser, BindingResult bindingResult) {

        if(!appUser.getPassword().equals(appUser.getPasswordConfirm())) {
            bindingResult.rejectValue("passwordConfirm","error.user","Hasło oraz potwierdzenie hasła nie są zgodne!");
            bindingResult.rejectValue("password","error.user","Hasło oraz potwierdzenie hasła nie są zgodne!");
        }

        boolean checkIfUserExist = this.userService.existByUsername(appUser.getUsername());
        boolean checkIfEmailWasUsed = this.userService.existByEmail(appUser.getEmail());

        if(checkIfUserExist) {
            bindingResult.rejectValue("username","error.user","Login jest zajęty!");
        }
//
        if(checkIfEmailWasUsed) {
            bindingResult.rejectValue("email","error.user","Adres email jest zajęty!");
        }
//
        if(bindingResult.hasErrors()) {
            return "register";
        }

        this.userService.signUpUser(appUser);

        return "redirect:/login";
    }

}
