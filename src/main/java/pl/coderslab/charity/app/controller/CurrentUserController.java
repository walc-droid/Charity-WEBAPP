package pl.coderslab.charity.app.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.app.user.AppUser;
import pl.coderslab.charity.app.user.AppUserRepository;
import pl.coderslab.charity.app.user.AppUserService;

import javax.validation.Valid;


@Controller
public class CurrentUserController {

    private final AppUserService userService;

    public CurrentUserController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logged")
    public String CurrentUser (@AuthenticationPrincipal AppUser appUser,Model model) {
        model.addAttribute("currentUser",appUser);
        return "profileUpdate";
    }

    @PostMapping("/logged")
    public String CurrentUserChangeName(@Valid@AuthenticationPrincipal AppUser loggedUser,AppUser newUserDetails, BindingResult bindingResult) {

        loggedUser.setFirstName(newUserDetails.getFirstName());
        loggedUser.setLastName(newUserDetails.getLastName());

        boolean checkIfUserExist = this.userService.existByUsername(newUserDetails.getUsername());


        if(bindingResult.hasErrors()) {
            return "redirect:/logged";
        }

        this.userService.save(loggedUser);
        return "redirect:/";
    }


    @GetMapping("/password")
    public String updatePW(@AuthenticationPrincipal AppUser appUser,Model model) {
        model.addAttribute("currentUser",appUser);
        return "pwUpdate";
    }

    @PostMapping("/password")
    public String updatePW(@AuthenticationPrincipal AppUser loggedUser, AppUser appUser) {

        loggedUser.setPassword(appUser.getPassword());
        loggedUser.setPasswordConfirm(appUser.getPasswordConfirm());

        this.userService.save(loggedUser);

        return "redirect:/logged";
    }



}
