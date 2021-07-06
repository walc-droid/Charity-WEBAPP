package pl.coderslab.charity.app.controller;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
import pl.coderslab.charity.app.user.AppUser;
import pl.coderslab.charity.app.user.AppUserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private DonationService donationService;
    private CategoryService categoryService;
    private InstitutionService institutionService;
    private AppUserService appUserService;


    public AdminPanelController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService, AppUserService appUserService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.appUserService = appUserService;
    }


    @GetMapping("/controlPanel")
    private String getAdminPanel () {
        return "Admin/AdminControlPanel";
    }


    @GetMapping("/donations")
    private String getDonation(Model model) {
        List<Donation> donationList = donationService.findAll();
        List<Institution> institutionList = this.institutionService.findAll();

        model.addAttribute("institutions", institutionList);
        model.addAttribute("donations",donationList);
        return "Admin/AdminDonationsList";
    }


    @GetMapping("/donations/edit/{id}")
    private String getDonationEdit (@PathVariable Long id,Model model) {
        Donation donation = this.donationService.findById(id);
        List<Institution> institutionList = this.institutionService.findAll();

        model.addAttribute("institution", institutionList);
        model.addAttribute("donation",donation);
        return "Admin/AdminDonationEdit";
    }


    @PostMapping("/donations/edit/{id}")
    private String getDonationEdit (@ModelAttribute Donation donation) {

        this.donationService.save(donation);
        return "redirect:/admin/donations";
    }


    @GetMapping("/donations/delete/{id}")
    private String deleteDonation (@PathVariable Long id) {
        this.donationService.delete(id);
        return "redirect:/admin/donations";
    }


    @GetMapping("/users")
    private String usersList (Model model) {
        List<AppUser> appUsers = this.appUserService.findAll();
        model.addAttribute("appUsers",appUsers);
        return "Admin/AdminUsersList";
    }


    @GetMapping("/users/edit/{id}")
    private String getUsersEdit (@PathVariable Long id, Model model) {
        AppUser appUser = this.appUserService.findById(id).orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono użytkownika"));
        model.addAttribute("appUser",appUser);
        return "Admin/AdminUserEdit";
    }


    @PostMapping("/users/edit/{id}")
    private String postUsersEdit(@ModelAttribute AppUser appUser) {
        AppUser appUserSave = appUser.setPasswordConfirm(appUser.getPassword());
        this.appUserService.save(appUserSave);
        return "redirect:/admin/users";
    }


    @GetMapping("/users/delete/{id}")
    private String deleteUser(@PathVariable Long id) {
        this.appUserService.delete(id);
        return "redirect:/admin/users";
    }


    @GetMapping("/institutions")
    private String getInstitutionList (Model model) {
        List<Institution> institutionList = this.institutionService.findAll();
        model.addAttribute("institutions", institutionList);
        return "Admin/AdminInstitutionsList";
    }


    @GetMapping("/institutions/add")
    private String institutionAdd (Model model) {
        model.addAttribute("institution",new Institution());
        return "Admin/AdminInstitutionAdd";
    }


    @PostMapping("/institutions/add")
    private String institutionAdd (@Valid Institution institution, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "Admin/AdminInstitutionsAdd";
        }

        this.institutionService.save(institution);
        return "redirect:/admin/institutions";
    }


    @GetMapping("/institutions/edit/{id}")
    private String institutionEdit (@PathVariable Long id, Model model) {
        Institution institution = this.institutionService.findById(id);
        model.addAttribute("institution",institution);
        return "Admin/AdminInstitutionEdit";
    }


    @PostMapping("/institutions/edit/{id}")
    private String institutionEditPost (@ModelAttribute Institution institution) {
        this.institutionService.save(institution);
        return "redirect:/admin/institutions";
    }


    @GetMapping("/institutions/delete/{id}")
    private String institutionDelete (@PathVariable Long id) {
        this.institutionService.delete(id);
        return "redirect:/admin/institutions";
    }



    @ModelAttribute("category")
    private List<Category> categoryList() {
        return this.categoryService.findAll();
    }



}
