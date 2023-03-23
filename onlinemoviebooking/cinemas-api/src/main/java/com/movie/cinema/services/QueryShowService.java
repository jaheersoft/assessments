package com.movie.cinema.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.cinema.documents.Cinema;
import com.movie.cinema.documents.Screen;
import com.movie.cinema.documents.Show;
import com.movie.cinema.dtos.MovieDTO;
import com.movie.cinema.repositories.CinemaMongoRepository;
import com.movie.cinema.repositories.ShowMongoRepository;

@Service
public class QueryShowService {

	@Autowired
	private ShowMongoRepository showMongoRepository;

	@Autowired
	private CinemaMongoRepository cinemaMongoRepository;

	@Autowired
	private RestTemplate template;

	public Map<Show, MovieDTO> findShowsByCity(String city) {
		List<Show> shows = new ArrayList<>();
		List<Cinema> cinemas = cinemaMongoRepository.findCinemasByCity(city);
		cinemas.forEach(c -> {
			c.getScreens().forEach(s -> {
				shows.addAll(showMongoRepository.findShowsByScreenId(s.getId()));
			});
		});
		Map<Show, MovieDTO> movieShows = new ConcurrentHashMap<Show, MovieDTO>();
		shows.forEach(show -> {
			getMovie(show.getMovieId()).thenAccept(movie -> movieShows.put(show, movie)).join();
		});
		return movieShows;
	}

	@Async
	public CompletableFuture<MovieDTO> getMovie(String movieId) {
		MovieDTO movieDTO = template.getForObject("http://localhost:8081/api/movie/" + movieId, MovieDTO.class);
		return CompletableFuture.completedFuture(movieDTO);
	}
}
