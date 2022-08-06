package com.imdbdata.imdbproject.database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.imdbdata.imdbproject.model.Rating;
import static com.imdbdata.imdbproject.utils.ReadTsvFileUtils.readFile;


public class RatingData {
    private static RatingData single_instance = null;
    public Map<String, Rating> ratings;
    private RatingData()
    {
        ratings = new HashMap<>();
    }
    public static RatingData getInstance() throws IOException
    {
        if (single_instance == null){
            single_instance = new RatingData();
            readFile("title.ratings.tsv/data.tsv").lines().skip(1).forEach(a -> {
                String[] data = a.split("\\t");
                Rating rating = new Rating(data[0],Float.parseFloat(data[1]),Integer.parseInt(data[2]));
                single_instance.ratings.put(rating.getTconst(), rating);
             });
        }
        return single_instance;
    }
}
