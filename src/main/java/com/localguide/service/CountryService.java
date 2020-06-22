package com.localguide.service;

import com.localguide.dao.CountryRepository;
import com.localguide.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Set<Country> getAllCountries(){
        Set<Country> countries = new HashSet<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }
    public void addCountry(Country newCountry){
        countryRepository.save(newCountry);
    }

    public Optional<Country> getCountry(Long id){
        return countryRepository.findById(id);
    }

    public void updateCountry(Country updateCountry){
        countryRepository.save(updateCountry);
    }
    public void deleteCountry(Country deleteCountry){
        countryRepository.delete(deleteCountry);
    }
}
