package pl.coderslab.charity.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.app.donation.Donation;
import pl.coderslab.charity.app.donation.DonationService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private DonationService donationService;

    public AdminPanelController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/controlPanel")
    private String getAdminPanel () {
        return "AdminControlPanel";
    }

    @GetMapping("/donation")
    private String getDonation(Model model) {
        List<Donation> donationList = donationService.findAll();
        model.addAttribute("donations",donationList);
        return "AdminDonationEdit";
    }


}
