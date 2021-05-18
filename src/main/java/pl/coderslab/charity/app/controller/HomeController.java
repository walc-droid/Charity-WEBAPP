package pl.coderslab.charity.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.app.donation.Donation;
import pl.coderslab.charity.app.institution.Institution;
import pl.coderslab.charity.app.donation.DonationService;
import pl.coderslab.charity.app.institution.InstitutionService;
import pl.coderslab.charity.app.user.AppUserService;

import java.util.List;


@Controller
public class HomeController {


    private final InstitutionService institutionService;

    private final DonationService donationService;
    private final AppUserService appUserService;


    public HomeController(InstitutionService institutionService, DonationService donationService, AppUserService appUserService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.appUserService = appUserService;
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
