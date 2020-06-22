package com.localguide.dao;

import com.localguide.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "review", path = "reviews")

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
