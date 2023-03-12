package com.movie.catalog.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie.catalog.entities.Movie;

public interface MovieJPARepository extends JpaRepository<Movie, String> {

	@Query(value = "select m from Movie m where m.addedOn = ?1")
	List<Movie> getAllMoviesAddedOn(Date addedOn);
}
