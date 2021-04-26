package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import java.util.List;


@Controller
public class HomeController {


    private final InstitutionService institutionService;

    private final DonationService donationService;

    private final UserService userService;

    public HomeController(InstitutionService institutionService, DonationService donationService, UserService userService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("donationsCount",this.donationService.donationsCount());
        model.addAttribute("quantityOfBags",this.donationService.quantityOfBags());
        return "homePage";
    }


    @ModelAttribute("institution")
    public List<Institution> institutions() {
        return this.institutionService.findTop4();
    }

    @ModelAttribute("donation")
    public List<Donation> donations() {
        return this.donationService.findAll();
    }

}
