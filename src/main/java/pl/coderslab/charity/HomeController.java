package pl.coderslab.charity;

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

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private DonationService donationService;

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("donationsCount",this.donationService.donationsCount());
        model.addAttribute("quantityOfBags",this.donationService.quantityOfBags());
        return "homePage";
    }


    @ModelAttribute("institution")
    public List<Institution> institutions() {
        return this.institutionService.findAll();
    }

    @ModelAttribute("donation")
    public List<Donation> donations() {
        return this.donationService.findAll();
    }

}
