package com.example.almgroupproject.repositories;

import com.example.almgroupproject.models.Director;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DirectorRepository extends MongoRepository<Director, Integer> {
    Director findDirectorByFirstNameAndLastName(String firstName, String lastName);
}
