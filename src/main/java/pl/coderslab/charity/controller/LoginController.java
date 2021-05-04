package pl.coderslab.charity.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";

    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

}
