package com.imdbdata.imdbproject.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadTsvFileUtils {
    public static final String PATH = "D:/projects/spring boot/dataset/";
    public static BufferedReader readFile(String name) throws IOException{
        Path path = Paths.get(PATH+name);
        BufferedReader reader = Files.newBufferedReader(path);
        return reader;
    }

    public static Scanner readFileEfficiant(String name) throws IOException{
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(PATH+name);
            sc = new Scanner(inputStream, "UTF-8");
            // note that Scanner suppresses exceptions
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        return sc;
    }
}
