package com.imdbdata.imdbproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdbdata.imdbproject.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

}
