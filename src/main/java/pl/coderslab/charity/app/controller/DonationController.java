package pl.coderslab.charity.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.app.category.Category;
import pl.coderslab.charity.app.donation.Donation;
import pl.coderslab.charity.app.institution.Institution;
import pl.coderslab.charity.app.category.CategoryService;
import pl.coderslab.charity.app.donation.DonationService;
import pl.coderslab.charity.app.institution.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {


    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    public DonationController(DonationService donationService, InstitutionService institutionService, CategoryService categoryService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/add")
    public String addPost (@Valid Donation donation, BindingResult violations) {

        if (violations.hasErrors()) {
            return "form";
        }

        this.donationService.save(donation);
        return "form-confirmation";
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
