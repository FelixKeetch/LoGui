package com.localguide.controller;

import com.localguide.entity.*;
import com.localguide.service.LanguageService;
import com.localguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LanguageService languageService;

    @RequestMapping("users")
    public HashSet<User> getUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("users/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @RequestMapping("users/byLangs")
    public HashSet<User> getUsersByLanguages(@RequestParam("lang") String[] langs){
        HashSet<LanguageEnum> searchlangs = languageService.getLanguages(langs);
        return userService.getUsersByLanguages(searchlangs);
    }

    @PostMapping("users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    @PutMapping("users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(user);
    }
    @DeleteMapping("users")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    @PostMapping("users/{id}/addLang")
    public void addLangs(@RequestParam("lang") String[] langs, @PathVariable Long id){
        userService.addLanguages(id,langs);
    }
    @PostMapping("users/{id}/trips/addTrip")
    public void addTrip(@RequestBody Trip trip, @PathVariable Long id, @RequestParam TGRole role){
        userService.addTrip(id, trip, role);
    }

}
