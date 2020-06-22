package com.localguide.dao;

import com.localguide.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "trip", path = "trips")

public interface TripRepository extends JpaRepository<Trip, Long> {
}
