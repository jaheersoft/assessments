package com.movie.cinema.repositories;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.movie.cinema.documents.Screen;
import com.movie.cinema.documents.Show;

public interface ShowMongoRepository extends MongoRepository<Show, String> {

	@Query(value = "{'screen': ?0}")
	public List<Show> findShowsByScreenId(String screen);
	
	@Query(value = "{'movieId': ?0}")
	public List<Show> findShowsByMovieId(String movieId);
	
	@Query(value = "{'time': ?0}")
	public List<Show> findShowsByShowTime(LocalDateTime time);
}
