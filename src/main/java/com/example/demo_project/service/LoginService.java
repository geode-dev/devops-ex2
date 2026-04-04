package com.example.demo_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.domain.Login;
import com.example.demo_project.repository.LoginRepo;

import jakarta.transaction.Transactional;

@Service
public class LoginService {
    @Autowired
    private LoginRepo repo;

    public Login log(String username, String password){
        Login user = repo.findByUsernameAndPassword(username, password);
        return user;
    }

    @Transactional
    public boolean delUser(String username, String password){
        Login user = repo.findByUsernameAndPassword(username, password);

        if (user != null){
            repo.delete(user);
            return true;
        }
        return false;
    }
}
