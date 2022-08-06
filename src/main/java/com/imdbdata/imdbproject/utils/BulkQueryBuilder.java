package com.imdbdata.imdbproject.utils;

import java.util.List;

import com.imdbdata.imdbproject.model.Rating;

public class BulkQueryBuilder {
    public static String ratingAddQuery(List<Rating> ratings){ 
        String q = "insert into Rating (tconst,averageRating,numVotes) VALUES ";
        int index = 1;
        for(Rating rating: ratings){
            String s = "('"+rating.getTconst()+"', "+rating.getAverageRating()+", "+rating.getNumVotes()+")";
            if(index!=ratings.size())
                s = s+",";    
            System.out.println(s);
            q = q + s;
            index++;
        }
        return q;
    }
}
