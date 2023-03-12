package com.movie.catalog.documents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	private String id;
	
	private String title;

	private String description ;
	
	private int durationInMins;
	
	private Date releaseDate;
	
	private String maturityRating;
	
	private int year;
	
	private String country;
	
	@Builder.Default
	private List<String> languages = new ArrayList<>();
	
	@Builder.Default
	private List<String> genres = new ArrayList<>();
	
	@DocumentReference
	@Builder.Default
	private List<MovieCast> movieCasts = new ArrayList<>();
}
