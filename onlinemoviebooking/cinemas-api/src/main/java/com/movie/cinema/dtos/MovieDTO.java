package com.movie.cinema.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
	//private String id;
	private String title;
	private String description;
	private int durationInMins;
	private Date releaseDate;
	private String maturityRating;
	private int year;
	private String country;
	
	@Builder.Default	
	private List<ShowDTO> shows = new ArrayList<>();
}
