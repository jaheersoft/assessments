package com.movie.catalog.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.movie.catalog.dtos.MovieDTO;
import com.movie.catalog.entities.Genre;
import com.movie.catalog.entities.Language;
import com.movie.catalog.entities.Movie;
import com.movie.catalog.entities.MovieCast;
import com.movie.catalog.repositories.MovieJPARepository;
import com.movie.catalog.repositories.MovieMongoRepository;

@Service
public class CommandMovieService {

	@Autowired
	private MovieJPARepository movieJPARepository;

	@Autowired
	private MovieMongoRepository movieMongoRepository;

	public Movie saveMovie(MovieDTO movieDTO) {
		Movie movie = Movie.builder().description(movieDTO.getDescription())
				.durationInMins(movieDTO.getDurationInMins()).maturityRating(movieDTO.getMaturityRating())
				.addedOn(new java.sql.Date(new java.util.Date().getTime())).country(movieDTO.getCountry()).year(movieDTO.getYear())
				.releaseDate(new java.sql.Date(movieDTO.getReleaseDate().getTime())).title(movieDTO.getTitle()).build();
		movieDTO.getCasts().forEach(dto -> {
			MovieCast cast = MovieCast.builder().cast(dto.getName()).role(dto.getRole()).movie(movie).build();
			movie.getMovieCasts().add(cast);
		});
		movieDTO.getLanguages().forEach(l -> {
			Language language = Language.builder().name(l.getName()).build();
			language.getMovies().add(movie);
			movie.getMovieLanguages().add(language);
		});
		movieDTO.getGenres().forEach(g -> {
			Genre genre = Genre.builder().name(g.getName()).build();
			genre.getMovies().add(movie);
			movie.getMovieGenres().add(genre);
		});
		return movieJPARepository.save(movie);
	}

	public Movie updateMovie(MovieDTO movieDTO) {
		Movie movie = Movie.builder().id(movieDTO.getId()).description(movieDTO.getDescription())
				.durationInMins(movieDTO.getDurationInMins()).maturityRating(movieDTO.getMaturityRating())
				.releaseDate(new java.sql.Date(movieDTO.getReleaseDate().getTime())).title(movieDTO.getTitle()).build();
		movieDTO.getCasts().forEach(dto -> {
			MovieCast cast = null;
			if (StringUtils.isEmpty(dto.getId())) {
				cast = MovieCast.builder().cast(dto.getName()).role(dto.getRole()).movie(movie).build();
			} else {
				cast = MovieCast.builder().id(dto.getId()).cast(dto.getName()).role(dto.getRole()).movie(movie).build();
			}
			movie.getMovieCasts().add(cast);
		});
		movieDTO.getLanguages().forEach(l -> {
			Language language = null;
			if (StringUtils.isEmpty(l.getId())) {
				language = Language.builder().name(l.getName()).build();
			} else {
				language = Language.builder().id(l.getId()).name(l.getName()).build();
			}
			language.getMovies().add(movie);
			movie.getMovieLanguages().add(language);
		});
		movieDTO.getGenres().forEach(g -> {
			Genre genre = null;
			if (StringUtils.isEmpty(g.getId())) {
				genre = Genre.builder().name(g.getName()).build();
			} else {
				genre = Genre.builder().id(g.getId()).name(g.getName()).build();
			}
			genre.getMovies().add(movie);
			movie.getMovieGenres().add(genre);
		});
		return movieJPARepository.save(movie);
	}

	public List<com.movie.catalog.documents.Movie> saveMovieToMongo(Date addedOn) {
		List<Movie> movies = movieJPARepository.findAll();
		List<com.movie.catalog.documents.Movie> movieDocuments = new ArrayList<>();
		movies.forEach(movie -> {
			com.movie.catalog.documents.Movie movieDocument = com.movie.catalog.documents.Movie.builder()
					.country(movie.getCountry()).description(movie.getDescription()).title(movie.getTitle())
					.durationInMins(movie.getDurationInMins()).maturityRating(movie.getMaturityRating())
					.releaseDate(movie.getReleaseDate()).year(movie.getYear()).build();
			movie.getMovieLanguages().forEach(ml -> {
				movieDocument.getLanguages().add(ml.getName());
			});
			movie.getMovieGenres().forEach(mg -> {
				movieDocument.getGenres().add(mg.getName());
			});
			movie.getMovieCasts().forEach(mc -> {
				com.movie.catalog.documents.MovieCast movieCast = com.movie.catalog.documents.MovieCast.builder()
						.id(mc.getId()).name(mc.getCast()).role(mc.getRole()).movie(movieDocument).build();
				movieDocument.getMovieCasts().add(movieCast);
			});
			movieDocuments.add(movieDocument);
		});
		return movieMongoRepository.saveAll(movieDocuments);
	}
}
