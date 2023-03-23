package com.movie.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movie.cinema.dtos.ShowDTO;
import com.movie.cinema.entities.Show;
import com.movie.cinema.services.CommandShowService;
import com.movie.cinema.services.QueryShowService;

@RestController
@RequestMapping("/api/show")
public class ShowController {

	@Autowired
	private CommandShowService commandService;
	
	@Autowired
	private QueryShowService queryShowService;
	
	@GetMapping("/city/{city}")
	private ResponseEntity<?> getShowsByCity(@PathVariable String city) {
		return new ResponseEntity<>(queryShowService.findShowsByCity(city),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> createCinema(@RequestBody ShowDTO showDTO) {
		Show show = commandService.addShow(showDTO);
		return new ResponseEntity<>(commandService.addShowToMongo(show),HttpStatus.OK);
	}
}
