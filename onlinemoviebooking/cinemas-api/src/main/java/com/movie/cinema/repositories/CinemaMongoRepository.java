package com.movie.cinema.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.movie.cinema.documents.Cinema;

public interface CinemaMongoRepository extends MongoRepository<Cinema, String> {

	@Query(value = "{'city': ?0}")
	public List<Cinema> findCinemasByCity(String city);
}
