package pl.coderslab.charity.app.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.app.user.AppUser;
import pl.coderslab.charity.app.user.AppUserService;


@Controller
public class CurrentUserController {

    private final AppUserService appUserService;

    public CurrentUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/logged")
    @ResponseBody
    public String CurrentUser(@AuthenticationPrincipal AppUser customUser) {
        this.appUserService.changeName(customUser.getUsername());

        return "Zmieniono imię";
    }






}
