package com.example.almgroupproject.repositories;

import com.example.almgroupproject.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {
    Movie findMovieByTitle(String title);
}
