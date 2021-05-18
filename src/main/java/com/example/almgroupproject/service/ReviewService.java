package com.example.almgroupproject.service;

import com.example.almgroupproject.models.Review;
import com.example.almgroupproject.repositories.ReviewRepository;
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
public class ReviewService {

    private final ReviewRepository repository;

    public List<Review> getAllReviews () {
        return repository.findAll();
    }


    public String save(Review review) {

        if (repository.findReviewById(review.getId()) != null) {
            return "Review already exists";
        }
        repository.save(review);
        return "Review saved";
    }
}
