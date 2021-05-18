package com.example.almgroupproject.service;

import com.example.almgroupproject.models.Review;
import com.example.almgroupproject.repositories.ReviewRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-05-18
 * Time: 13:19
 * Project: almGroupProject
 * Copyright: MIT
 */
@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @Mock
    ReviewRepository reviewRepository;
    
    @DisplayName("Test for get all reviews")
    @Test
    void getAllReviews() {

        String expectedId = "1";
        String expectedComment = "Slösade 2 timmar av mitt liv för detta!?";
        int expectedRating = 5;

        Review newReview1 = new Review();
        newReview1.setId(expectedId);
        newReview1.setComment(expectedComment);
        newReview1.setRating(expectedRating);

        ReviewService reviewService = new ReviewService(reviewRepository);

        List<Review> list = new ArrayList<>();

        list.add(newReview1);

        when(reviewRepository.findAll()).thenReturn(list);
        assertEquals(reviewService.getAllReviews(), Arrays.asList(newReview1));
    }

    @DisplayName("Test for save a review")
    @Test
    void save() {

        String expectedId = "2";
        String expectedComment = "Jag grät och skrattade";
        int expectedRating = 2;

        Review newReview2 = new Review();
        newReview2.setId(expectedId);
        newReview2.setComment(expectedComment);
        newReview2.setRating(expectedRating);

        ReviewService reviewService = new ReviewService(reviewRepository);

        assertEquals(reviewService.save(newReview2), "Review saved");
        when(reviewRepository.findReviewByIdAndCommentAndRating(newReview2.getId(), newReview2.getComment(), newReview2.getRating())).thenReturn(newReview2);
        assertEquals(reviewService.save(newReview2), "Review already exists");
    }
}