package pl.coderslab.charity.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CurrentUser;

@Controller
public class CurrentUserController {

    @GetMapping("/logged")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Test " + entityUser.getUsername() + " " + entityUser.getPassword();
    }

}
