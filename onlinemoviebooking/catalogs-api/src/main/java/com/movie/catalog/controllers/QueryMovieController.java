package com.movie.catalog.controllers;

import java.util.Date;

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
	
	@GetMapping("/language/{language}")
	public ResponseEntity<?> getMoviesByLanguage(@PathVariable String language) {
		try {
			return new ResponseEntity<>(queryMovieService.getMoviesByLanguage(language), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<?> getMoviesByTitle(@PathVariable String title) {
		try {
			return new ResponseEntity<>(queryMovieService.getMoviesByTitle(title), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/releasedate/{releaseDate}")
	public ResponseEntity<?> getMoviesByTitle(@PathVariable Date releaseDate) {
		try {
			return new ResponseEntity<>(queryMovieService.getMoviesByReleaseDate(releaseDate), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}
}
