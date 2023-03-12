package com.movie.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movie.catalog.entities.Genre;

public interface GenreJPARepository extends JpaRepository<Genre, String>{

}
