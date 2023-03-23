package com.movie.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movie.cinema.entities.Show;

public interface ShowJPARepository extends JpaRepository<Show, String> {

}
