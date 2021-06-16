package pl.coderslab.charity.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    @GetMapping("/test")
    @ResponseBody
    private String test () {
        return "test123";
    }

}
