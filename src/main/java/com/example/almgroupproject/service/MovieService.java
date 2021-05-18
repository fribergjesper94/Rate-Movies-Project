package com.example.almgroupproject.service;

import com.example.almgroupproject.models.Movie;
import com.example.almgroupproject.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
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
public class MovieService {

    private final MovieRepository repository;

    public List<Movie> getAllMovies(){
        return repository.findAll();
    }

}
