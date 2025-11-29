package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.login.UserRegistration;
import com.example.demo.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    // Show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistration());
        return "register";
    }

    // Handle registration submission
    @PostMapping("/addUser")
    public String registerUser(@ModelAttribute("user") UserRegistration user) {
        userService.register(user);
        return "redirect:/login?registered";  // After success go to login page
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginPage(
            @RequestParam(value = "registered", required = false) String registered,
            Model model) {
        if (registered != null) {
            model.addAttribute("message", "Registration successful! Please login.");
        }
        return "login";
    }
}
