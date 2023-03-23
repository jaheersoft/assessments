package com.movie.cinema.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.cinema.documents.Screen;

public interface ScreenMongoRepository extends MongoRepository<Screen, String>{

}
