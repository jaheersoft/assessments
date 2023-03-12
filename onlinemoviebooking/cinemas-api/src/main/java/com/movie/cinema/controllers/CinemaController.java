package com.movie.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.cinema.dtos.CinemaDTO;
import com.movie.cinema.entities.Cinema;
import com.movie.cinema.services.CommandCinemaService;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {
	
	@Autowired
	private CommandCinemaService commandCinemaService;

	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Cinema> createCinema(@RequestBody CinemaDTO cinemaDTO) {
		Cinema cinema = commandCinemaService.saveCinema(cinemaDTO);
		return new ResponseEntity<>(cinema,HttpStatus.OK);
	}
}
