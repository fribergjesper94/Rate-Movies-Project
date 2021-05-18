package com.example.almgroupproject.controller;

import com.example.almgroupproject.models.Actor;
import com.example.almgroupproject.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-17
 * Time: 14:32
 * Project: almGroupProject
 * Copyright: MIT
 */
@RestController("actor")
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService service;

    @GetMapping(path = "/all")
    public List<Actor> allActors () {

        return service.getAllActors();
    }

    @PostMapping(path = "/add")
    public String addActor (@RequestBody Actor actor) {
        return service.save(actor);
    }


}
