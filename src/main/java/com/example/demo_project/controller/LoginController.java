package com.example.demo_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo_project.domain.Login;
import com.example.demo_project.domain.Student;
import com.example.demo_project.repository.LoginRepo;
import com.example.demo_project.repository.CourseRepo;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LoginController {
    @Autowired
    private LoginRepo repo;

    @Autowired
    private CourseRepo studrepo;

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        
        Login user = repo.findByUsernameAndPassword(username, password);

        if (user != null){
            session.setAttribute("username", username);
            return "redirect:/welcome";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    @GetMapping("/welcome")
    public String showWelcomePage(Model model) {
        List<Student> studs= studrepo.findAll();
        model.addAttribute("liststudent",studs);
        return "welcome";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
