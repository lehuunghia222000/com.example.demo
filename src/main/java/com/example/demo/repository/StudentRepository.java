package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByAgeIs(int age);
}
