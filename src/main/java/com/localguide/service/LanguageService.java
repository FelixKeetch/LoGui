package com.localguide.service;

import com.localguide.dao.LanguageRepository;
import com.localguide.entity.Country;
import com.localguide.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public Set<Language> getAllLanguages(){
        Set<Language> languages = new HashSet<>();
        languageRepository.findAll().forEach(languages::add);
        return languages;
    }
    public Set<Language> getLanguages(List<String> langs){
        Set<Language> languages = new HashSet<>();
        languageRepository.findAllByNameIn(langs).forEach(languages::add);
        return languages;
    }




    public void addLanguage(Language newLanguage){
        languageRepository.save(newLanguage);
    }

    public Optional<Language> getLanguage(Long id){
        return languageRepository.findById(id);
    }

    public void updateLanguage(Language updateLanguage){
        languageRepository.save(updateLanguage);
    }
    public void deleteLanguage(Language deleteLanguage){
        languageRepository.delete(deleteLanguage);
    }

}

