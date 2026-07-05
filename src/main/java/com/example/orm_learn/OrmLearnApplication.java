package com.example.orm_learn;

import com.example.orm_learn.model.Country;
import com.example.orm_learn.Service.CountryService;
import com.example.orm_learn.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        getCountryTest();
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
}