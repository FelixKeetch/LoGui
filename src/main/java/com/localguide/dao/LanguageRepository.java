package com.localguide.dao;

import com.localguide.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    public Language findFirstByName(String name);
    public Set<Language> findAllByNameIn(List<String> langs);

}
