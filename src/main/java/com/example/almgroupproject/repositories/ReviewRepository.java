package com.example.almgroupproject.repositories;

import com.example.almgroupproject.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-05-18
 * Time: 09:11
 * Project: almGroupProject
 * Copyright: MIT
 */
public interface ReviewRepository extends MongoRepository<Review, String> {
    Review findReviewById (String id);
    Review findReviewByComment (String comment);
    Review findReviewByIdAndCommentAndRating (String id, String comment, int rating);
}
