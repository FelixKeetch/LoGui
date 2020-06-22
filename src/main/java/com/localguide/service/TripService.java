package com.localguide.service;

import com.localguide.dao.TripRepository;
import com.localguide.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public Set<Trip> getAllTrips(){
        HashSet<Trip> trips = new HashSet<>();
        tripRepository.findAll().forEach(trips::add);
        return trips;
    }
    public void addTrip(Trip newTrip){
        tripRepository.save(newTrip);
    }

    public Optional<Trip> getTrip(Long id){
        return tripRepository.findById(id);
    }

    public void updateTrip(Trip updateTrip){
        tripRepository.save(updateTrip);
    }
    public void deleteTrip(Trip deleteTrip){
        tripRepository.delete(deleteTrip);
    }

}
