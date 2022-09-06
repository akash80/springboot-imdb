package com.imdbdata.imdbproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.imdbdata.imdbproject.model.Crew;
import com.imdbdata.imdbproject.model.Name;
import com.imdbdata.imdbproject.model.Principal;
import com.imdbdata.imdbproject.model.Rating;
import com.imdbdata.imdbproject.model.Title;
import com.imdbdata.imdbproject.service.CrewService;
import com.imdbdata.imdbproject.service.NameService;
import com.imdbdata.imdbproject.service.PrincipalService;
import com.imdbdata.imdbproject.service.RatingService;
import com.imdbdata.imdbproject.service.TitleService;

import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_CREW_PATH;
import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_PRINCIPAL_PATH;
import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_NAME_PATH;
import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_RATING_PATH;
import static com.imdbdata.imdbproject.config.Configuration.DATA_SET_TITLE_PATH;
import static com.imdbdata.imdbproject.config.Configuration.LIMIT;
import static com.imdbdata.imdbproject.config.Configuration.H2_MODE;;
@SpringBootApplication
public class ImdbProjectApplication { 
	public static void main(String[] args) throws IOException {
		SpringApplication.run(ImdbProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(CrewService crewService,NameService nameService,PrincipalService principalService,RatingService ratingService,TitleService titleService ) {
		return (args) -> {
			if(H2_MODE){
				long start = System.currentTimeMillis();
				List<Crew> crews = Files.lines(Paths.get(DATA_SET_CREW_PATH)).limit(LIMIT).map(obj -> new Crew(obj.split("\\t"))).collect(Collectors.toList());
				crewService.saveBulk(crews);
				List<Name> names = Files.lines(Paths.get(DATA_SET_NAME_PATH)).limit(LIMIT).map(obj -> new Name(obj.split("\\t"))).collect(Collectors.toList());
				nameService.saveBulk(names);
				List<Principal> principals = Files.lines(Paths.get(DATA_SET_PRINCIPAL_PATH)).limit(LIMIT).map(obj -> new Principal(obj.split("\\t"))).collect(Collectors.toList());
				principalService.saveBulk(principals);
				List<Rating> ratings = Files.lines(Paths.get(DATA_SET_RATING_PATH)).limit(LIMIT).map(obj -> new Rating(obj.split("\\t"))).collect(Collectors.toList());
				ratingService.saveBulk(ratings);
				List<Title> titles = Files.lines(Paths.get(DATA_SET_TITLE_PATH)).limit(LIMIT).map(obj -> new Title(obj.split("\\t"))).collect(Collectors.toList());
				titleService.saveBulk(titles);
				long end = System.currentTimeMillis();
				System.out.println("total time: "+(end-start));
			}
		};
	}
}
