package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo_project.domain.Student;
import com.example.demo_project.repository.CourseRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CourseController {
    @Autowired
    private CourseRepo repo;
    
    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        // This is the missing piece! 
        // Thymeleaf needs this 'student' object to bind to th:object="${student}"
        Student student = new Student(); 
        model.addAttribute("student", student);
        
        return "new"; // Ensure this matches your HTML filename (new.html)
    }

    @PostMapping("/save")
    public String postMethodName(@RequestParam String studentname, @RequestParam String course, @RequestParam int fee) {
        Student student = new Student(studentname, course, fee); 
        repo.save(student);
        
        return "redirect:/welcome";
    }
    

    
    
}
