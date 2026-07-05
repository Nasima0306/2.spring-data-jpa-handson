package com.example.orm_learn.repository;

import com.example.orm_learn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {
}