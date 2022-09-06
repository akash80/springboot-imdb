package com.imdbdata.imdbproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdbdata.imdbproject.model.Rating;
import com.imdbdata.imdbproject.repository.RatingRepository;


@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void saveBulk(List<Rating> ratings) {
        ratingRepository.saveAll(ratings);
    }

    public Optional<Rating> getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId);
    }

    public void deeteRating(Rating rating) {
        ratingRepository.delete(rating);
    }

    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

}
