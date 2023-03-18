package com.movie.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movie.catalog.services.QueryMovieService;

@RestController
@RequestMapping("/api/movie")
public class QueryMovieController {

	@Autowired
	private QueryMovieService queryMovieService;

	@GetMapping("/all")
	public ResponseEntity<?> getAllMovies() {
		try {
			return new ResponseEntity<>(queryMovieService.getAllMovies(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	@GetMapping("/genre/{genre}")
	public ResponseEntity<?> getMoviesByGeneres(@PathVariable String genre) {
		try {
			return new ResponseEntity<>(queryMovieService.getMoviesByGenre(genre), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}
}
