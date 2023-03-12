package com.movie.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movie.catalog.entities.Language;

public interface LanguageJPARepository extends JpaRepository<Language, String> {

}
