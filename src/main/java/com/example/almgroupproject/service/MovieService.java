package com.example.almgroupproject.service;

import com.example.almgroupproject.models.Actor;
import com.example.almgroupproject.models.Movie;
import com.example.almgroupproject.repositories.ActorRepository;
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

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public String save(Movie movie) {
        movieRepository.save(movie);
        return "Movie saved";
    }

    public String addActorToMovie(String title, String firstname, String lastname) {
        Actor selectedActor = actorRepository.findActorByFirstNameAndLastName(firstname,lastname);
        Movie selectedMovie = movieRepository.findMovieByTitle(title);

        if(selectedActor == null){
            return "Actor not found";
        }else if (selectedMovie == null){
            return "Movie not found";
        }else if(selectedMovie.getActorList().contains(selectedActor)){
            return "Actor already in movie";
        }
        
        selectedMovie.addActorToList(selectedActor);
        movieRepository.save(selectedMovie);

        return "Actor added to movie";
    }
}
