package com.movie.cinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.cinema.dtos.CinemaDTO;
import com.movie.cinema.entities.Cinema;
import com.movie.cinema.entities.Screen;
import com.movie.cinema.entities.Seat;
import com.movie.cinema.entities.Show;
import com.movie.cinema.repositories.CinemaJPARepository;

@Service
public class CommandCinemaService {

	@Autowired
	private CinemaJPARepository cinemaRepository;

	public Cinema saveCinema(CinemaDTO cinemaCTO) {
		Cinema cinema = Cinema.builder().name(cinemaCTO.getName()).address(cinemaCTO.getAddress())
				.city(cinemaCTO.getCity()).country(cinemaCTO.getCountry()).build();
		cinemaCTO.getScreens().forEach(s -> {
			Screen screen = Screen.builder().name(s.getName()).build();
			s.getSeats().forEach(st -> {
				Seat seat = Seat.builder().number(st.getNumber()).row(st.getRow()).type(st.getType()).screen(screen)
						.build();
				screen.getSeats().add(seat);
			});
			/*s.getShows().forEach(sh -> {
				Show show = Show.builder().
						//time(new Timestamp(sh.getShowTime().)).
						isAvailable(true)
						.movieId(sh.getMovieId()).screen(screen).build();
				screen.getShows().add(show);
			});*/
			cinema.getScreens().add(screen);
		});
		return cinemaRepository.save(cinema);
	}
}
