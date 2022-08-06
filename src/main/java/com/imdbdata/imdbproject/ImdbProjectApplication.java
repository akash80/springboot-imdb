package com.imdbdata.imdbproject;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.imdbdata.imdbproject.database.RatingData;

@SpringBootApplication
public class ImdbProjectApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ImdbProjectApplication.class, args);
		// intialize data
		RatingData.getInstance();
	}

}
