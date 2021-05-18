package com.example.almgroupproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-17
 * Time: 14:04
 * Project: almGroupProject
 * Copyright: MIT
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private String id;

    private String title;
    private List<Actor> actorList = new ArrayList<>();
    private String genre;
    private List<Review> reviewList = new ArrayList<>();
    private Director director;

    public void addActorToList(Actor actor){
        if(!actorList.contains(actor)){
            actorList.add(actor);
        }
    }

    public void addReviewToList(Review review){
        if(!reviewList.contains(review)){
            reviewList.add(review);
        }
    }
}
