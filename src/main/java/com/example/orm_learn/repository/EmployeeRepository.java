package com.example.orm_learn.repository;

import com.example.orm_learn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();
}