package com.localguide.dao;

import com.localguide.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "hobby", path = "hobbies")

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}
