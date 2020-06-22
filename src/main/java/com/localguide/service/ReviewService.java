package com.localguide.service;

import com.localguide.dao.ReviewRepository;
import com.localguide.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Set<Review> getAllReviews(){
        HashSet<Review> reviews = new HashSet<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }
    public void addReview(Review newReview){
        reviewRepository.save(newReview);
    }

    public Optional<Review> getReview(Long id){
        return reviewRepository.findById(id);
    }

    public void updateReview(Review updateReview){
        reviewRepository.save(updateReview);
    }
    public void deleteReview(Review deleteReview){
        reviewRepository.delete(deleteReview);
    }
}
