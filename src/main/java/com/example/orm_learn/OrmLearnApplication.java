package com.example.orm_learn;

import com.example.orm_learn.Service.CountryService;
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
    public void run(String... args) {

        countryService.searchCountries("ou")
                .forEach(System.out::println);
        countryService.searchCountriesSorted("ou")
                .forEach(System.out::println);
    }
}