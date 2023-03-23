package com.movie.cinema.services;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.cinema.dtos.ShowDTO;
import com.movie.cinema.entities.Screen;
import com.movie.cinema.entities.Show;
import com.movie.cinema.repositories.ShowJPARepository;
import com.movie.cinema.repositories.ShowMongoRepository;

@Service
public class CommandShowService {
	
	@Autowired
	private ShowJPARepository showJPARepository;
	
	@Autowired
	private ShowMongoRepository showMongoRepository;
	
	public Show addShow(ShowDTO showDTO) {
		Show show = Show.builder()
				.movieId(showDTO.getMovieId())
				.screen(Screen.builder().id(showDTO.getScreenId()).build())
				.time(new Timestamp(Date.from(showDTO.getShowTime().toInstant(ZoneOffset.UTC)).getTime()))
				.build();
		return showJPARepository.save(show);
	}
	
	public com.movie.cinema.documents.Show addShowToMongo(Show show) {
		com.movie.cinema.documents.Show mongoShow = com.movie.cinema.documents.Show.builder().id(show.getId())
				.movieId(show.getMovieId())
				.screen(com.movie.cinema.documents.Screen.builder().id(show.getScreen().getId()).build())
				.time(show.getTime().toLocalDateTime())
				.build();
		return showMongoRepository.save(mongoShow);
	}
}
