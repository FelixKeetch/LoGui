package com.localguide.dao;

import com.localguide.entity.City;
import com.localguide.entity.LanguageEnum;
import com.localguide.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
@RepositoryRestResource(collectionResourceRel = "user")
public interface UserRepository extends JpaRepository<User, Long> {
    public HashSet<User> findAllByCity(City city);
    public HashSet<User> findAllByLanguagesIn(HashSet<LanguageEnum> languages);
}
