package com.example.almgroupproject.service;

import com.example.almgroupproject.models.Actor;
import com.example.almgroupproject.models.Director;
import com.example.almgroupproject.models.Movie;
import com.example.almgroupproject.models.Review;
import com.example.almgroupproject.repositories.ActorRepository;
import com.example.almgroupproject.repositories.MovieRepository;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    MovieRepository mockMovieRepository;

    @Mock
    ActorRepository mockActorRepository;

    MovieService movieService;

    List<Actor> allActorsList;
    List<Movie> allMoviesList;

    @BeforeEach
    void init(){
        movieService = new MovieService(mockMovieRepository,mockActorRepository);

        Actor actor1 = new Actor("1","Tom","Kryssning", LocalDate.of(1962,7,3));
        Director director1 = new Director("1","Micke","Bukt","Unknown");
        Review review1 = new Review("1","Supernajs!",8);

        Movie movie1 = new Movie();
        movie1.setId("1");
        movie1.setTitle("Disaster Movie");
        movie1.setGenre("Comedy");
        movie1.addReviewToList(review1);
        movie1.setDirector(director1);

        allActorsList = Arrays.asList(actor1);
        allMoviesList = Arrays.asList(movie1);
    }

    @DisplayName("Test for get all movies")
    @Test
    void getAllMovies() {
        when(mockMovieRepository.findAll()).thenReturn(allMoviesList);

        assertEquals(allMoviesList,movieService.getAllMovies());
    }

    @DisplayName("Test for save movie")
    @Test
    void save() {
        Movie movie = new Movie();
        movie.setId("1");
        movie.setTitle("Hajen");

        movieService.save(movie);

        verify(mockMovieRepository).save(any());
    }

    @DisplayName("Test for adding unknown actor to a movie")
    @Test
    void addActorToMovieActorNotFound() {

        Movie movie = new Movie();
        movie.setId("1");
        movie.setTitle("Hajen");

        when(mockMovieRepository.findMovieByTitle("Hajen")).thenReturn(movie);

        String result = movieService.addActorToMovie("Hajen","Janne","Surkål");
        String expected = "Actor not found";

        assertEquals(expected,result);

    }

    @DisplayName("Test for adding actor to unknown movie")
    @Test
    void addActorToMovieMovieNotFound() {

        Actor actor = new Actor("1","Tom","Kryssning", LocalDate.of(1962,7,3));

        when(mockActorRepository.findActorByFirstNameAndLastName(actor.getFirstName(),actor.getLastName())).thenReturn(actor);

        String result = movieService.addActorToMovie("Hajen",actor.getFirstName(),actor.getLastName());
        String expected = "Movie not found";

        assertEquals(expected,result);
    }

    @DisplayName("Test for adding actor who is already in movie")
    @Test
    void addActorToMovieActorAlreadyInMovie() {
        Actor actor = new Actor("1","Tom","Kryssning", LocalDate.of(1962,7,3));

        Movie movie = new Movie();
        movie.setId("1");
        movie.setTitle("Hajen");
        movie.addActorToList(actor);

        when(mockActorRepository.findActorByFirstNameAndLastName(actor.getFirstName(),actor.getLastName())).thenReturn(actor);
        when(mockMovieRepository.findMovieByTitle("Hajen")).thenReturn(movie);

        String result = movieService.addActorToMovie(movie.getTitle(),actor.getFirstName(),actor.getLastName());
        String expected = "Actor already in movie";

        assertEquals(expected,result);

    }

    @DisplayName("Test for adding actor to a movie successfully")
    @Test
    void addActorToMovie() {

        Actor actor = new Actor("1","Tom","Kryssning", LocalDate.of(1962,7,3));

        Movie movie = new Movie();
        movie.setId("1");
        movie.setTitle("Hajen");


        when(mockActorRepository.findActorByFirstNameAndLastName(actor.getFirstName(),actor.getLastName())).thenReturn(actor);
        when(mockMovieRepository.findMovieByTitle("Hajen")).thenReturn(movie);

        String result = movieService.addActorToMovie(movie.getTitle(),actor.getFirstName(),actor.getLastName());
        String expected = "Actor added to movie";

        assertEquals(expected,result);

    }
}