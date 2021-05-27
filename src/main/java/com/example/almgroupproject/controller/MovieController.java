package com.example.almgroupproject.controller;

import com.example.almgroupproject.models.Movie;
import com.example.almgroupproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/add")
    public String addMovie(@RequestBody Movie movie){
        return movieService.save(movie);
    }

    @PutMapping(path = "/addActor")
    public String addActorToMovie(@RequestParam String title, @RequestParam String firstname, @RequestParam String lastname){
        return movieService.addActorToMovie(title,firstname,lastname);
    }

    @PutMapping(path = "/addDirector")
    public String addDirectorToMovie(@RequestParam String title, @RequestParam String firstname, @RequestParam String lastname) {
        return movieService.addDirectorToMovie(title, firstname, lastname);
    }
}
