package com.example.almgroupproject.controller;

import com.example.almgroupproject.models.Actor;
import com.example.almgroupproject.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-17
 * Time: 14:32
 * Project: almGroupProject
 * Copyright: MIT
 */

@RestController("actor")
public class ActorController {

    private final ActorService service;

    @GetMapping(path = "/all")
    public List<Actor> allActors () {

        return service
    }


}
