package com.example.almgroupproject.controller;

import com.example.almgroupproject.models.Review;
import com.example.almgroupproject.service.ReviewService;
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
@RestController("review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @GetMapping(path = "/all")
    public List<Review> allReviews () {

        return service.getAllReviews();
    }

    @PostMapping(path = "/add")
    public String addReview (@RequestBody Review review) {
        return service.save(review);
    }

}
