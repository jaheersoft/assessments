package com.movie.catalog.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.catalog.documents.Movie;
import com.movie.catalog.repositories.MovieMongoRepository;

@Service
public class QueryMovieService {

	@Autowired
	private MovieMongoRepository movieMongoRepository;
	
	public List<Movie> getAllMovies() {
		return movieMongoRepository.findAll();
	}
	
	public Optional<Movie> getMoviesById(String id) {
		return movieMongoRepository.findById(id);
	}
	
	public List<Movie> getMoviesByGenre(String genre) {
		return movieMongoRepository.findMoviesByGenre(genre);
	}
	
	public List<Movie> getMoviesByLanguage(String genre) {
		return movieMongoRepository.findMoviesByLanguage(genre);
	}
	
	public List<Movie> getMoviesByReleaseDate(Date date) {
		return movieMongoRepository.findMoviesByReleaseDate(date);
	}
	
	public List<Movie> getMoviesByTitle(String title) {
		return movieMongoRepository.findMoviesByTitle(title);
	}
}
