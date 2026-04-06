package com.example.demo_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.domain.Login;
import com.example.demo_project.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    private LoginRepo repo;

    public Login log(String username, String password){
        Login user = repo.findByUsernameAndPassword(username, password);
        return user;
    }
}
