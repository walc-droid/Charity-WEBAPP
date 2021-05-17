package pl.coderslab.charity.app.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.app.user.User;
import pl.coderslab.charity.app.user.CurrentUser;
import pl.coderslab.charity.app.user.UserService;


@Controller
public class CurrentUserController {

    private final UserService userService;

    public CurrentUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logged")
    public String CurrentUser(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
//        Optional<User> newEdit = this.userRepository.findByUserName(entityUser.getUserName());
        model.addAttribute("currentUser",entityUser);
        return "profileUpdate";
    }


    @PostMapping("/logged")
    public String CurrentUserDataUpdate(User user) {


        this.userService.saveUser(user);

        return "profileUpdate";
    }



}
