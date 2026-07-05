package com.example.orm_learn.repository;

import com.example.orm_learn.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, Integer> {
}