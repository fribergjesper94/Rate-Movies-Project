package com.example.almgroupproject.repositories;

import com.example.almgroupproject.models.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-17
 * Time: 15:00
 * Project: almGroupProject
 * Copyright: MIT
 */
@Repository
public interface ActorRepository extends MongoRepository <Actor, String> {

}
