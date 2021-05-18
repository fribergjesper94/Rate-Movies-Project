package com.example.almgroupproject.service;

import com.example.almgroupproject.models.Actor;
import com.example.almgroupproject.repositories.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-17
 * Time: 14:57
 * Project: almGroupProject
 * Copyright: MIT
 */
@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository repository;

    public List<Actor> getAllActors () {
        return repository.findAll();
    }


    public String save(Actor actor) {

        if (repository.findActorByFirstNameAndLastName(actor.getFirstName(), actor.getLastName()) != null) {
            return "Actor already exists";
        }
        repository.save(actor);
      return "Actor saved";
    }
}
