package com.movie.catalog.controllers;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movie.catalog.dtos.MovieDTO;
import com.movie.catalog.entities.Movie;
import com.movie.catalog.services.CommandMovieService;

@RestController
@RequestMapping("/api/movie")
public class CommandMovieController {

	@Autowired
	private CommandMovieService commandMovieService;
	
	@PostMapping("/add")
	public ResponseEntity<List<com.movie.catalog.documents.Movie>> saveMovie(@RequestBody MovieDTO movieDTO) {
		try {
			Movie movie = commandMovieService.saveMovie(movieDTO);
			List<com.movie.catalog.documents.Movie> movies = commandMovieService.saveMovieToMongo(movie.getAddedOn());
			return new ResponseEntity<>(movies,HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.OK);
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
