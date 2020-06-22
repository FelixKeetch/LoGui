package com.localguide.service;

import com.localguide.dao.CityRepository;
import com.localguide.dao.CountryRepository;
import com.localguide.entity.City;
import com.localguide.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public Set<City> getAllCities(){
        Set<City> cities = new HashSet<>();
        cityRepository.findAll().forEach(cities::add);
        return cities;
    }
    public void addCity(City newCity){
        cityRepository.save(newCity);
    }

    public Optional<City> getCity(Long id){
        return cityRepository.findById(id);
    }

    public void updateCity(City updateCity){
        cityRepository.save(updateCity);
    }
    public void deleteCity(City deleteCity){
        cityRepository.delete(deleteCity);
    }
}
