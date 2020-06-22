package com.localguide.controller;

import com.localguide.entity.Language;
import com.localguide.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @RequestMapping("lang")
    public Set<Language> getAllLanguages(){
        return languageService.getAllLanguages();
    }
    @PostMapping("lang")
    public void addLanguage(@RequestBody Language lang){
        languageService.addLanguage(lang);
    }


}
