package pl.coderslab.charity.app.controller;


import javassist.NotFoundException;
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

    @GetMapping("/donation/delete/{id}")
    private String deleteDonation (@PathVariable Long id) {
        this.donationService.delete(id);
        return "redirect:/admin/donation";
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
        return "Admin/AdminUsersEdit";
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


    @GetMapping("/institution")
    private String getInstitutionList () {
        return "Admin/AdminInstitutionsList";
    }

    @GetMapping("/institution/add")
    private String institutionAdd (Model model) {
        model.addAttribute("instit",new Institution());
        return "Admin/AdminInstitutionsAdd";
    }

    @PostMapping("/institution/add")
    private String institutionAdd (@Valid Institution institution, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "Admin/AdminInstitutionsAdd";
        }


        this.institutionService.save(institution);
        return "Admin/AdminInstitutionsList";
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
