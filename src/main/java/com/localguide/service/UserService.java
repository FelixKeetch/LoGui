package com.localguide.service;

import com.localguide.dao.TripRepository;
import com.localguide.dao.UserRepository;
import com.localguide.entity.LanguageEnum;
import com.localguide.entity.TGRole;
import com.localguide.entity.Trip;
import com.localguide.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LanguageService languageService;
    
    public HashSet<User> getAllUsers(){
        HashSet<User> usrs = new HashSet<>();
        userRepository.findAll().forEach(usrs::add);
        return usrs;
    }
    public HashSet<User> getUsersByLanguages(HashSet<LanguageEnum> langs){
        return userRepository.findAllByLanguagesIn(langs);
    }

    public void addUser(User newUser){
        userRepository.save(newUser);
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public void updateUser(User updateUser){
        userRepository.save(updateUser);
    }
    public void deleteUser(User deleteUser){
        userRepository.delete(deleteUser);
    }

    public void addLanguages(Long id, String[] langs) {
        User user = userRepository.getOne(id);
        HashSet<LanguageEnum> langSet = languageService.getLanguages(langs);
        user.setLanguages(langSet);
        userRepository.save(user);
    }

    public void addTrip(Long id, Trip trip, TGRole role) {
        User user = userRepository.getOne(id);
        if(role.equals(TGRole.GUIDE))
            user.getGuideTrips().add(trip);
        else
            user.getTouristTrips().add(trip);
        userRepository.save(user);
    }



}
