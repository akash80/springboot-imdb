package com.imdbdata.imdbproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.imdbdata.imdbproject.model.Crew;
import com.imdbdata.imdbproject.service.CrewService;
import com.imdbdata.imdbproject.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/h2")
public class ImdbH2Controller{

    @Autowired
    RatingService ratingService;

    @Autowired
    CrewService crewService;

    @GetMapping("/query1")
    public List<String> getQuery1() throws IOException {
        long start = System.currentTimeMillis();
        List<Crew> crews = crewService.getAll();
        System.out.println(crews.size());
        long end = System.currentTimeMillis();
        System.out.println("Time: "+(end-start));
        return null;
    }
}