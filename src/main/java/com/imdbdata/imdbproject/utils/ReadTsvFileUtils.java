package com.imdbdata.imdbproject.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReadTsvFileUtils {
    public static BufferedReader readFile(String name) throws IOException{
        Path path = Paths.get(name);
        BufferedReader reader = Files.newBufferedReader(path);
        return reader;
    }

    public static Scanner readFileEfficiant(String name) throws IOException{
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(name);
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

    public static boolean findCommonElements(String[] arr1,
    String[] arr2)
    {
        if (arr1.length > 0 && arr2.length > 0) {
            Set<String> firstSet = new HashSet<String>();
            for (int i = 0; i < arr1.length; i++) {
                firstSet.add(arr1[i]);
            }
           
            for (int j = 0; j < arr2.length; j++) {
                if (firstSet.contains(arr2[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
