package com.example.orm_learn.Service;

import com.example.orm_learn.model.Employee;
import com.example.orm_learn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }
}