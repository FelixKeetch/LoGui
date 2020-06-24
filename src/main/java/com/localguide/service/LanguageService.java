package com.localguide.service;

import com.localguide.entity.Language;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LanguageService {

//    @Autowired
//    private LanguageRepository languageRepository;

    public Set<Language> getAllLanguages(){
        Language ls[] = Language.values();
        HashSet<Language> lsset = new HashSet<>();
        for(Language l : ls)
            lsset.add(l);
        return lsset;
    }
}

