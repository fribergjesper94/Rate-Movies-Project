package com.example.almgroupproject.controller;

import com.example.almgroupproject.models.Director;
import com.example.almgroupproject.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-17
 * Time: 14:43
 * Project: almGroupProject
 * Copyright: MIT
 */
@RestController("director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService service;

    @GetMapping(path = "/all")
    public List<Director> allDirectors() {
        return service.getAllDirectors();
    }

    @PostMapping(path = "/add")
    public String addDirector(@RequestBody Director director) {
        return service.save(director);
    }
}
