package com.movie.catalog.dtos;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDTO {
	private String id;
	private String title;
	private String description;
	private int durationInMins;
	private Date releaseDate;
	private String maturityRating;
	private int year;
	private String country;
	private List<LanguageDTO> languages;
	private List<GenreDTO> genres;
	private List<CastDTO> casts;
}
