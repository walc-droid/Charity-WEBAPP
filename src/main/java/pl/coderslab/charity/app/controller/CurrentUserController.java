package pl.coderslab.charity.app.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.app.user.AppUser;
import pl.coderslab.charity.app.user.AppUserRepository;
import pl.coderslab.charity.app.user.AppUserService;


@Controller
public class CurrentUserController {

    private final AppUserRepository appUserRepository;

    public CurrentUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/logged")
    public String CurrentUser (@AuthenticationPrincipal AppUser appUser,Model model) {
        AppUser user = this.appUserRepository.getByEmail(appUser.getEmail());
        model.addAttribute("currentUser",user);
        return "profileUpdate";
    }

    @PostMapping("/logged")
    public String CurrentUserChangeName(AppUser appUser) {

        this.appUserRepository.save(appUser);
        return "redirect:/";
    }




}
