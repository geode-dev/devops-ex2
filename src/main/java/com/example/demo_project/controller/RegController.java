package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo_project.service.RegService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


@Controller
public class RegController {
    @Autowired
    private RegService service;

    @GetMapping("/register")
    public String showRegPage() {
        return "register";
    }

    @PostMapping("/register")
    public String regUser(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isReg = service.registerUser(username, password);
        if (isReg){
            model.addAttribute("message", "Registration successful! Please login.");
            return "login";
        }
        model.addAttribute("error", "Username already exists");
        return "register";
    }    
}
