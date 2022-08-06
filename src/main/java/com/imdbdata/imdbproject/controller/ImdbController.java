package com.imdbdata.imdbproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.imdbdata.imdbproject.database.RatingData;
import com.imdbdata.imdbproject.model.Rating;
import com.imdbdata.imdbproject.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.imdbdata.imdbproject.utils.ReadTsvFileUtils.readFile;
import static com.imdbdata.imdbproject.utils.BulkQueryBuilder.ratingAddQuery;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class ImdbController{

    @Autowired
    RatingService ratingService;

    @GetMapping("/{id}")
    public Rating get(@PathVariable("id") String ratingId) throws IOException {
        Rating rating =  RatingData.getInstance().ratings.get(ratingId);
        return rating;
    }

    @GetMapping("/setData")
    public String set() throws IOException {
        long start = System.currentTimeMillis();
        RatingData.getInstance();
        long end = System.currentTimeMillis();
        return "takes " +
        (end - start) + "ms";
    }
}