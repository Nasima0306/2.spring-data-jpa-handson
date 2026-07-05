package com.example.orm_learn;

import com.example.orm_learn.Service.EmployeeService;
import com.example.orm_learn.model.Country;
import com.example.orm_learn.Service.CountryService;
import com.example.orm_learn.exception.CountryNotFoundException;
import com.example.orm_learn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;
    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAllPermanentEmployees();
    }

    private void getCountryTest() {

        System.out.println("Start");

        try {
            Country country = countryService.findCountryByCode("IN");
            System.out.println(country);
        } catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("End");
    }

    private void testAddCountry() {

        System.out.println("Start");

        Country country = new Country();
        country.setCode("NP");
        country.setName("Nepal");

        countryService.addCountry(country);

        try {
            Country addedCountry = countryService.findCountryByCode("NP");
            System.out.println("Added Country : " + addedCountry);
        } catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("End");
    }

    private void testUpdateCountry() {

        System.out.println("Start");

        countryService.updateCountry("NP", "New Nepal");

        try {
            Country country = countryService.findCountryByCode("NP");
            System.out.println("Updated Country : " + country);
        } catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("End");
    }
    private void testDeleteCountry() {

        System.out.println("Start");

        countryService.deleteCountry("NP");

        try {
            Country country = countryService.findCountryByCode("NP");
            System.out.println(country);
        } catch (CountryNotFoundException e) {
            System.out.println("Country deleted successfully");
        }

        System.out.println("End");
    }
    private void testGetAllPermanentEmployees() {

        System.out.println("Start");

//        EmployeeService employeeService = null;
        List<Employee> employees =
                employeeService.getAllPermanentEmployees();

        employees.forEach(System.out::println);

        System.out.println("End");
    }
}