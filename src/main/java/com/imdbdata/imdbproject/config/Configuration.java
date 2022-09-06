package com.imdbdata.imdbproject.config;

public class Configuration {
    public static final String BASE_PATH = System.getProperty("user.dir")+"/dataset/";
    public static final String DATA_SET_NAME_PATH = BASE_PATH+"name.basics.tsv/data.tsv";
    public static final String DATA_SET_TITLE_PATH = BASE_PATH+"title.basics.tsv/data.tsv";
    public static final String DATA_SET_CREW_PATH = BASE_PATH+"title.crew.tsv/data.tsv";
    public static final String DATA_SET_PRINCIPAL_PATH = BASE_PATH+"title.principals.tsv/data.tsv";
    public static final String DATA_SET_RATING_PATH = BASE_PATH+"title.ratings.tsv/data.tsv";
    public static final boolean H2_MODE = false;
    public static final int LIMIT = 1000000;
}
