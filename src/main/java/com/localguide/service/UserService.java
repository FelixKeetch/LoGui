package com.localguide.service;

import com.localguide.dao.UserRepository;
import com.localguide.entity.Language;
import com.localguide.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Set<User> getAllUsers(){
        Set<User> usrs = new HashSet<>();
        userRepository.findAll().forEach(usrs::add);
        return usrs;
    }
    public Set<User> getUsersByLanguages(Set<Language> langs){
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

}
