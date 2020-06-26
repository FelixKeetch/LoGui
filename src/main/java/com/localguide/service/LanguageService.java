package com.localguide.service;

import com.localguide.entity.LanguageEnum;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LanguageService {

    public HashSet<LanguageEnum> getAllLanguages(){
        LanguageEnum ls[] = LanguageEnum.values();
        HashSet<LanguageEnum> lsset = new HashSet<>();
        for(LanguageEnum l : ls)
            lsset.add(l);
        return lsset;
    }

    public HashSet<LanguageEnum> getLanguages(String[] searchlangs) {
        HashSet<LanguageEnum> returnSet = new HashSet<>();
        for (String s : searchlangs )
            returnSet.add(LanguageEnum.valueOf(s));
        return returnSet;
    }
}

