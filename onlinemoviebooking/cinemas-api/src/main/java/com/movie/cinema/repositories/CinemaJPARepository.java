package com.movie.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.cinema.entities.Cinema;

public interface CinemaJPARepository extends JpaRepository<Cinema, String>{

}
