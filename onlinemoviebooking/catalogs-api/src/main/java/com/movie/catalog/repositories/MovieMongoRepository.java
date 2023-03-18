package com.movie.catalog.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.movie.catalog.documents.Movie;

public interface MovieMongoRepository extends MongoRepository<Movie, String> {
	
	@Query(value = "{'title': ?0}")
	public List<Movie> findMoviesByTitle(String title);
	
	@Query(value = "{'releaseDate': ?0}")
	public List<Movie> findMoviesByReleaseDate(Date releaseDate);
	
	@Query(value = "{'languages': ?0}")
	public List<Movie> findMoviesByLanguage(String language);
	
	@Query(value = "{'genres': ?0}")
	public List<Movie> findMoviesByGenre(String genre);
}
