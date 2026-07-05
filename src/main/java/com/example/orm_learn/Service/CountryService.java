package com.example.orm_learn.Service;

import com.example.orm_learn.model.Country;
import com.example.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> searchCountries(String text) {
        return countryRepository.findByNameContaining(text);
    }
    public List<Country> searchCountriesSorted(String text) {
        return countryRepository
                .findByNameContainingOrderByNameAsc(text);
    }
}