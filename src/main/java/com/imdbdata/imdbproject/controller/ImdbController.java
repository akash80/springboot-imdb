package com.imdbdata.imdbproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.imdbdata.imdbproject.database.CrewData;
import com.imdbdata.imdbproject.database.HttpCalls;
import com.imdbdata.imdbproject.database.NameData;
import com.imdbdata.imdbproject.database.PrincipalData;
import com.imdbdata.imdbproject.database.RatingData;
import com.imdbdata.imdbproject.database.TitleData;
import com.imdbdata.imdbproject.model.Crew;
import com.imdbdata.imdbproject.model.Name;
import com.imdbdata.imdbproject.model.Principal;
import com.imdbdata.imdbproject.model.Rating;
import com.imdbdata.imdbproject.model.Title;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ImdbController{

    @GetMapping("/rating/{id}")
    public Rating getRating(@PathVariable("id") String ratingId) throws IOException {
        Rating rating =  RatingData.getInstance().ratings.get(ratingId);
        int i = HttpCalls.getInstance().calls;
        return rating;
    }

    @GetMapping("/name/{id}")
    public Name getName(@PathVariable("id") String nameId) throws IOException {
        Name name =  NameData.getInstance().names.get(nameId);
        int i = HttpCalls.getInstance().calls;
        return name;
    }

    @GetMapping("/principal/{id}")
    public Principal getPrincipal(@PathVariable("id") String id) throws IOException {
        Principal name =  PrincipalData.getInstance().principals.get(id);
        int i = HttpCalls.getInstance().calls;
        return name;
    }

    @GetMapping("/crew/{id}")
    public Crew getCrew(@PathVariable("id") String id) throws IOException {
        Crew name =  CrewData.getInstance().crews.get(id);
        int i = HttpCalls.getInstance().calls;
        return name;
    }

    @GetMapping("/title/{id}")
    public Title getTitle(@PathVariable("id") String id) throws IOException {
        Title name =  TitleData.getInstance().titles.get(id);
        int i = HttpCalls.getInstance().calls;
        return name;
    }

    @GetMapping("/calls")
    public int getCalls() throws IOException {
        return HttpCalls.getInstance().calls;
    }
}