package com.imdbdata.imdbproject.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.imdbdata.imdbproject.database.RatingData;
import com.imdbdata.imdbproject.model.Rating;

public class ReadTsvFileUtils {
    private static final String PATH = "D:/projects/spring boot/dataset/";
    public static BufferedReader readFile(String name) throws IOException{
        Path path = Paths.get(PATH+name);
        BufferedReader reader = Files.newBufferedReader(path);
        return reader;
    }
}
