package com.localguide.service;

import com.localguide.dao.HobbyRepository;
import com.localguide.entity.Hobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class HobbyService {
    @Autowired
    private HobbyRepository hobbyRepository;

    public Set<Hobby> getAllHobbies(){
        Set<Hobby> hobbies = new HashSet<>();
        hobbyRepository.findAll().forEach(hobbies::add);
        return hobbies;
    }
    public void addHobby(Hobby newHobby){
        hobbyRepository.save(newHobby);
    }

    public Optional<Hobby> getHobby(Long id){
        return hobbyRepository.findById(id);
    }

    public void updateHobby(Hobby updateHobby){
        hobbyRepository.save(updateHobby);
    }
    public void deleteHobby(Hobby deleteHobby){
        hobbyRepository.delete(deleteHobby);
    }
}

