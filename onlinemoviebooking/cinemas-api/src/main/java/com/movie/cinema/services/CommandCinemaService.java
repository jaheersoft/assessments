package com.movie.cinema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.cinema.dtos.CinemaDTO;
import com.movie.cinema.entities.Cinema;
import com.movie.cinema.entities.Screen;
import com.movie.cinema.entities.Seat;
import com.movie.cinema.repositories.CinemaJPARepository;
import com.movie.cinema.repositories.CinemaMongoRepository;
import com.movie.cinema.repositories.ScreenMongoRepository;
import com.movie.cinema.repositories.SeatMongoRepository;

@Service
public class CommandCinemaService {

	@Autowired
	private CinemaJPARepository cinemaRepository;
	
	@Autowired
	private CinemaMongoRepository cinemaMongoRepository; 
	
	@Autowired
	private ScreenMongoRepository screenMongoRepository; 
	
	@Autowired
	private SeatMongoRepository seatMongoRepository; 

	public Cinema saveCinema(CinemaDTO cinemaCTO) {
		Cinema cinema = Cinema.builder().name(cinemaCTO.getName()).address(cinemaCTO.getAddress())
				.city(cinemaCTO.getCity()).country(cinemaCTO.getCountry()).build();
		cinemaCTO.getScreens().forEach(s -> {
			Screen screen = Screen.builder().name(s.getName()).cinema(cinema).build();
			s.getSeats().forEach(st -> {
				Seat seat = Seat.builder().number(st.getNumber()).row(st.getRow()).type(st.getType()).screen(screen)
						.build();
				screen.getSeats().add(seat);
			});
			cinema.getScreens().add(screen);
		});
		return cinemaRepository.save(cinema);
	}
	
	public com.movie.cinema.documents.Cinema saveCinemaToMongo(Cinema cinema) {
		com.movie.cinema.documents.Cinema mongoCinema = com.movie.cinema.documents.Cinema.builder().id(cinema.getId())
												.address(cinema.getAddress())
												.city(cinema.getCity())
												.country(cinema.getCountry())
												.name(cinema.getName()).build();
		cinema.getScreens().forEach(s -> {
			com.movie.cinema.documents.Screen screen = com.movie.cinema.documents.Screen.builder().id(s.getId()).name(s.getName()).cinema(mongoCinema).build();
			s.getSeats().forEach(st -> {
				com.movie.cinema.documents.Seat seat = com.movie.cinema.documents.Seat.builder().id(st.getId()).number(st.getNumber()).row(st.getRow()).type(st.getType()).screen(screen)
						.build();
				seatMongoRepository.save(seat);
				screen.getSeats().add(seat);
			});
			screenMongoRepository.save(screen);
			mongoCinema.getScreens().add(screen);
		});
		return cinemaMongoRepository.save(mongoCinema);
	}
}
