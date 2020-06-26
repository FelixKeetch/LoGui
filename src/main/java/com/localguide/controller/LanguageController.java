package com.localguide.controller;
import com.localguide.entity.LanguageEnum;
import com.localguide.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;

@RestController
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @RequestMapping("lang")
    public HashSet<LanguageEnum> getAllLanguages(){
        return languageService.getAllLanguages();
    }
}
