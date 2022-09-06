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
import com.imdbdata.imdbproject.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.lang3.StringUtils;

import static com.imdbdata.imdbproject.utils.ReadTsvFileUtils.readFile;
import static com.imdbdata.imdbproject.utils.ReadTsvFileUtils.findCommonElements;
import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_RATING_PATH;
import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_CREW_PATH;
import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_NAME_PATH;
import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_TITLE_PATH;
import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_PRINCIPAL_PATH;
import static com.imdbdata.imdbproject.config.Configuration.LIMIT;
@RestController
@RequestMapping("/api/stream")
public class ImdbStreamController{

    @Autowired
    RatingService ratingService;

    @GetMapping("/calls")
    public int getCalls() throws IOException {
        return HttpCalls.getInstance().calls;
    }

    @GetMapping("/query1")
    public List<String> getQuery1() throws IOException {
        BidiMap<String,String> map = new TreeBidiMap<>();
        Files.lines(Paths.get(DATA_SET_CREW_PATH)).limit(LIMIT)
        .filter(s -> !s.split("\\t")[1].contains("\\N") && !s.split("\\t")[2].contains("\\N") && findCommonElements(s.split("\\t")[1].split(","),s.split("\\t")[2].split(","))).forEach(data -> {
            map.put(data.split("\\t")[0], data.split("\\t")[1]);
        });    
        List<String> alive = Files.lines(Paths.get(DATA_SET_NAME_PATH)).limit(LIMIT)
            .filter(s -> map.containsValue(s.split("\\t")[0]) && !s.split("\\t")[2].contains("N") && s.split("\\t")[3].contains("N")).map(s -> map.getKey(s.split("\\t")[0])).collect(Collectors.toList());
        List<String> titles = Files.lines(Paths.get(DATA_SET_TITLE_PATH)).limit(LIMIT)
            .filter(s -> alive.contains(s.split("\\t")[0])).map(t -> t.split("\\t")[3]).collect(Collectors.toList());
            System.out.println(titles.size());  
        return titles;
    }

    @GetMapping("/query2/{actor1}/{actor2}")
    public Set<String> getQuery2(@PathVariable String actor1, @PathVariable String actor2) throws IOException {
        Set<String> actors = Files.lines(Paths.get(DATA_SET_NAME_PATH)).limit(LIMIT)
        .filter(s -> s.split("\\t")[1].equalsIgnoreCase(actor1) || s.split("\\t")[1].equalsIgnoreCase(actor2)).map(s -> s.split("\\t")[0]).limit(2).collect(Collectors.toSet());
        System.out.println(actors);
        List<String> acts = actors.stream().map(s -> s).collect(Collectors.toList());
        Set<String> titles = Files.lines(Paths.get(DATA_SET_PRINCIPAL_PATH)).limit(LIMIT)
        .filter(s -> actors.contains(s.split("\\t")[2])).map(s -> s.split("\\t")[0]+","+s.split("\\t")[2]).collect(Collectors.toSet());
        System.out.println(titles);
        Set<String> actor1Titles = titles.stream().filter(s -> s.contains(acts.get(0))).map(s -> s.split(",")[0]).collect(Collectors.toSet());
        Set<String> actor2Titles = titles.stream().filter(s -> s.contains(acts.get(1))).map(s -> s.split(",")[0]).collect(Collectors.toSet());
        System.out.println(actor1Titles);
        System.out.println(actor2Titles);
        actor1Titles.retainAll(actor2Titles);
        Set<String> res = Files.lines(Paths.get(DATA_SET_NAME_PATH)).limit(LIMIT)
        .filter(s -> actor1Titles.contains(s.split("\\t")[0])).map(s -> s.split("\\t")[2]).collect(Collectors.toSet());
        return res;
    }
}