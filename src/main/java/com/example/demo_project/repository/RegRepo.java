package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.domain.Login;

@Repository
public interface RegRepo extends JpaRepository<Login, String>{
    Login findByUsername(String username);
    
}
