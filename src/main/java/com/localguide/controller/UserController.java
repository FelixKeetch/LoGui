package com.localguide.controller;

import com.localguide.entity.Language;
import com.localguide.entity.User;
import com.localguide.service.LanguageService;
import com.localguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LanguageService languageService;

    @RequestMapping("users")
    public Set<User> getUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("users/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @RequestMapping("users/langs")
    public Set<User> getUsersByLanguages(@RequestParam List<String> searchlangs){
        Set<Language> langs = languageService.getLanguages(searchlangs);
        return userService.getUsersByLanguages(langs);
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
}
