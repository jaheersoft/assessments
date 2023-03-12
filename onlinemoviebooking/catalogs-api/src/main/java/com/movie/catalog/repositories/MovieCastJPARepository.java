package com.movie.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.catalog.entities.MovieCast;

public interface MovieCastJPARepository extends JpaRepository<MovieCast, String> {

}
