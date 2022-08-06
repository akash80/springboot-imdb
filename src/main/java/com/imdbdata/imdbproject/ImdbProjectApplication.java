package com.imdbdata.imdbproject;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.imdbdata.imdbproject.database.CrewData;
import com.imdbdata.imdbproject.database.NameData;
import com.imdbdata.imdbproject.database.PrincipalData;
import com.imdbdata.imdbproject.database.RatingData;
import com.imdbdata.imdbproject.database.TitleData;

@SpringBootApplication
public class ImdbProjectApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ImdbProjectApplication.class, args);
		// intialize data
		RatingData.getInstance();
		NameData.getInstance();
		CrewData.getInstance();
		PrincipalData.getInstance();
		TitleData.getInstance();
		System.out.println("*****************Loaded***********************");
	}

}
