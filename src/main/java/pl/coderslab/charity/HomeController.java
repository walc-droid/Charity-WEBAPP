package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("donationsCount",this.donationRepository.count());
        model.addAttribute("quantityOfBags",this.donationRepository.quantityOfBags());
        return "homePage";
    }


    @ModelAttribute("institution")
    public List<Institution> institutions() {
        return this.institutionRepository.findAll();
    }

    @ModelAttribute("donation")
    public List<Donation> donations() {
        return this.donationRepository.findAll();
    }

}
