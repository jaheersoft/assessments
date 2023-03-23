package com.movie.cinema.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.movie.cinema.documents.Seat;

public interface SeatMongoRepository extends MongoRepository<Seat, String>{

}
