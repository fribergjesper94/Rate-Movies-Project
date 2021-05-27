package com.example.almgroupproject.controller;

import com.example.almgroupproject.models.Movie;
import com.example.almgroupproject.models.Review;
import com.example.almgroupproject.repositories.MovieRepository;
import com.example.almgroupproject.service.MovieService;
import com.example.almgroupproject.service.ReviewService;
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
@RestController("review")
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;
    private final MovieRepository movieRepository;

    @GetMapping(path = "/all")
    public List<Review> allReviews () {

        return service.getAllReviews();
    }

    @PostMapping(value = "/add/{title}")
    public String addReview (@PathVariable String title, @RequestBody Review review) {
        Movie selectedMovie = movieRepository.findMovieByTitle(title);

        if (selectedMovie == null) {
            return "Selected movie not found";
        }
        selectedMovie.addReviewToList(review);
        movieRepository.save(selectedMovie);

        return service.save(review);
    }

}
