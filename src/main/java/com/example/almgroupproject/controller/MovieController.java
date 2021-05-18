package com.example.almgroupproject.controller;

import com.example.almgroupproject.models.Movie;
import com.example.almgroupproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-17
 * Time: 14:43
 * Project: almGroupProject
 * Copyright: MIT
 */

@RestController("movie")
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    public final MovieService movieService;

    @GetMapping(path = "/all")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
}
