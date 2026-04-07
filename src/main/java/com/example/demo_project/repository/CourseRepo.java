package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.domain.Student;

@Repository
public interface CourseRepo extends JpaRepository<Student, Long>{
    
}
