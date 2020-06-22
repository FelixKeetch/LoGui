package com.localguide.dao;

import com.localguide.entity.City;
import com.localguide.entity.Language;
import com.localguide.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RepositoryRestResource(collectionResourceRel = "user")
public interface UserRepository extends JpaRepository<User, Long> {
    public Set<User> findAllByCity(City city);
    public Set<User> findAllByLanguagesIn(Set<Language> languages);
}
