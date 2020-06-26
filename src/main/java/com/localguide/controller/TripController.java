package com.localguide.controller;

import com.localguide.dao.TripRepository;
import com.localguide.entity.Review;
import com.localguide.entity.Trip;
import com.localguide.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping("trips")
    public Set<Trip> getAllTrips(){
        return tripService.getAllTrips();
    }
    @PostMapping("trips/{id}/addReview")
    public void addReview(@PathVariable Long id, @RequestBody Review review){
        tripService.addReview(id, review);
    }


}
