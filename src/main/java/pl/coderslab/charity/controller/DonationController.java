package pl.coderslab.charity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;
    @Autowired
    private InstitutionService institutionService;

    @ModelAttribute("institution")
    public List<Institution> institutions() {
        return this.institutionService.findAll();
    }

}
