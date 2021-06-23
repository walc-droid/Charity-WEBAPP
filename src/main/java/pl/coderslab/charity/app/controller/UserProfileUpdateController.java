package pl.coderslab.charity.app.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
public class UserProfileUpdateController {

    private final AppUserService userService;

    public UserProfileUpdateController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logged")
    public String CurrentUser (@AuthenticationPrincipal AppUser appUser,Model model) {
        model.addAttribute("currentUser",appUser);
        return "User/UserProfileUpdate";
    }

    @PostMapping("/logged")
    public String CurrentUserChangeName(@Valid@AuthenticationPrincipal AppUser loggedUser,@ModelAttribute("currentUser") AppUser newUserDetails, BindingResult bindingResult) {

        loggedUser.setFirstName(newUserDetails.getFirstName());
        loggedUser.setLastName(newUserDetails.getLastName());


        if(bindingResult.hasErrors()) {
            return "redirect:/logged";
        }

        this.userService.save(loggedUser);
        return "redirect:/";
    }


    @GetMapping("/password")
    public String updatePW(@AuthenticationPrincipal AppUser appUser,Model model) {
        model.addAttribute("currentUser",appUser);
        return "User/UserPasswordUpdate";
    }

    @PostMapping("/password")
    public String updatePW(@Valid@AuthenticationPrincipal AppUser loggedUser,@ModelAttribute("currentUser") AppUser appUser, BindingResult bindingResult) {


        if(!loggedUser.getPassword().equals(appUser.getPasswordConfirm())) {
            bindingResult.rejectValue("passwordConfirm","error.user","Stare hasło jest niepoprawne!");
        }

        if(bindingResult.hasErrors()) {
            return "User/UserPasswordUpdate";
        }

        loggedUser.setPassword(appUser.getPassword());
        loggedUser.setPasswordConfirm(appUser.getPassword());

        this.userService.save(loggedUser);

        return "redirect:/logged";
    }



}
