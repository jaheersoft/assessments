package com.movie.catalog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.movie.catalog.documents.MovieCast;

public interface MovieCastMongoRepository extends MongoRepository<MovieCast, String> {

}
