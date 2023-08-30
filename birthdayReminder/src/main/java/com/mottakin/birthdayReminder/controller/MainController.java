package com.mottakin.birthdayReminder.controller;

import com.mottakin.birthdayReminder.model.Birthday;
import com.mottakin.birthdayReminder.service.BirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private BirthdayService birthdayService;

    @GetMapping("/")
    public String homePage()
    {
        return "home-page.html";
    }

    @PostMapping("/find-serial-favourites")
    public String searchFavourite(@RequestParam Integer id, Model model) {
        model.addAttribute("birthday", birthdayService.searchById(id));
        return "find-favourites.html";
    }
    @GetMapping("/add-favourite-people")
    public String addBirthday() {
        return "add-favourite-people.html";
    }
    @PostMapping("/save-favourite-people")
    public String saveBirthday(@ModelAttribute Birthday birthday) {
        birthdayService.addBirthday(birthday);
        return "home-page.html";
    }
    @GetMapping("/list-all-birthdays")
    public String listAllBirthday(Model model) {
        model.addAttribute("birthdayList", birthdayService.getAllBirthday());
        return "all-candidates-page.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable("id") Integer id) {
        birthdayService.deleteExpense(id);
        return "redirect:/list-all-birthdays";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Birthday birthday = birthdayService.searchById(id);
        if (birthday != null) {
            model.addAttribute("birthday", birthday);
            return "update-form"; // Replace with the actual Thymeleaf template name
        }
        return null;
    }


    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable Integer id, @ModelAttribute Birthday updatedBirthday) {
        Birthday birthday = birthdayService.searchById(id);
        if (birthday != null) {
            birthday.setId(updatedBirthday.getId());
            birthday.setName(updatedBirthday.getName());
            birthday.setMonthDate(updatedBirthday.getMonthDate());

            return "redirect:/list-all-birthdays"; // Redirect to the expenses list page after updating
        }
        return null;
    }

}
