package com.movie.catalog.controllers;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movie.catalog.dtos.MovieDTO;
import com.movie.catalog.entities.Movie;
import com.movie.catalog.services.CommandMovieService;
import com.movie.catalog.services.QueryMovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	private CommandMovieService commandMovieService;
	
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

	@GetMapping("/{id}")
	public ResponseEntity<?> getMovieById(@PathVariable String id) {
		try {
			return new ResponseEntity<>(queryMovieService.getMoviesById(id), HttpStatus.OK);
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
	
	@PostMapping("/add")
	public ResponseEntity<?> saveMovie(@RequestBody MovieDTO movieDTO) {
		try {
			Movie movie = commandMovieService.saveMovie(movieDTO);
			List<com.movie.catalog.documents.Movie> movies = commandMovieService.saveMovieToMongo(movie.getAddedOn());
			return new ResponseEntity<>(movies,HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateMovie(@RequestBody MovieDTO movieDTO) {
		try {
			return new ResponseEntity<>(commandMovieService.updateMovie(movieDTO),HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("Problem occurred with saving movie "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Scheduled(cron = "0 0 6 * * ?")
	public void addMoviestoMongoDB() {
		commandMovieService.saveMovieToMongo(new Date(new java.util.Date().getTime()));
	}
}
