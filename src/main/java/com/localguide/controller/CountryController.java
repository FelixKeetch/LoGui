package com.localguide.controller;

import com.localguide.entity.Country;
import com.localguide.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @RequestMapping("country")
    public HashSet<Country> getAllCountries(){
           return countryService.getAllCountries();
    }

    @PostMapping("country")
    public void addCountry(@RequestBody Country country){ countryService.addCountry(country);}

}
