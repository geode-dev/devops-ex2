package com.example.demo_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.domain.Login;
import com.example.demo_project.repository.RegRepo;

@Service
public class RegService {
    @Autowired
    private RegRepo repo;

    public boolean registerUser(String username, String password){
        if (repo.findByUsername(username) != null){
            return false;
        }
        Login newUser = new Login(username, password);
        repo.save(newUser);
        return true;

    }
    
}
