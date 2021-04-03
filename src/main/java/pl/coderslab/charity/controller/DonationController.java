package pl.coderslab.charity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
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
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("donation", new Donation());
        return "addDonation";
    }

    @PostMapping("/add")
    public String addPost (Donation donation) {
        this.donationService.save(donation);
        return "homePage";
    }



    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return this.institutionService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return this.categoryService.findAll();
    }
}