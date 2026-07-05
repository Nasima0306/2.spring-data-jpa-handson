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
        testUpdateCountry();
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
}