package pl.coderslab.charity.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.app.category.Category;
import pl.coderslab.charity.app.category.CategoryService;
import pl.coderslab.charity.app.donation.Donation;
import pl.coderslab.charity.app.donation.DonationService;
import pl.coderslab.charity.app.institution.Institution;
import pl.coderslab.charity.app.institution.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private DonationService donationService;
    private CategoryService categoryService;
    private InstitutionService institutionService;

    public AdminPanelController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping("/controlPanel")
    private String getAdminPanel () {
        return "Admin/AdminControlPanel";
    }

    @GetMapping("/donation")
    private String getDonation(Model model) {
        List<Donation> donationList = donationService.findAll();
        model.addAttribute("donations",donationList);
        return "Admin/AdminDonationList";
    }


    @GetMapping("/donation/edit/{id}")
    private String getDonationEdit (@PathVariable Long id,Model model) {
        Donation donation = this.donationService.findById(id);
        model.addAttribute("donationEdit",donation);
        return "Admin/AdminDonationEdit";
    }

    @PostMapping("/donation/edit/{id}")
    private String getDonationEdit (@ModelAttribute Donation donation) {

        this.donationService.save(donation);

        return "redirect:/admin/donation";
    }

    @ModelAttribute("category")
    private List<Category> categoryList() {
        return this.categoryService.findAll();
    }

    @ModelAttribute("institution")
    private List<Institution> institutionList() {
        return this.institutionService.findAll();
    }

}
