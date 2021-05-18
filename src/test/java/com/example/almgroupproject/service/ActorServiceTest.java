package com.example.almgroupproject.service;

import com.example.almgroupproject.models.Actor;
import com.example.almgroupproject.repositories.ActorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-18
 * Time: 13:51
 * Project: almGroupProject
 * Copyright: MIT
 */
@ExtendWith(MockitoExtension.class)
public class ActorServiceTest {

    @Mock
    ActorRepository mockRepository;

    @DisplayName("Gets all actors in the list")
    @Test
    public void getAllActorsTest() {
        Actor actor1 = new Actor("1", "Förnamn1", "Efternamn1", LocalDate.of(1994, 12, 17));
        Actor actor2 = new Actor("2", "Förnamn2", "Efternamn2", LocalDate.of(1979, 3, 12));
        Actor actor3 = new Actor("3", "Förnamn3", "Efternamn3", LocalDate.of(1990, 10, 20));
        ActorService service = new ActorService(mockRepository);
        List<Actor> actorList = new ArrayList<>();
        actorList.add(actor1);
        actorList.add(actor2);
        actorList.add(actor3);

        when(mockRepository.findAll())
        .thenReturn(actorList);
        assertEquals(service.getAllActors(), Arrays.asList(actor1, actor2, actor3));
    }

    @Test
    public void saveActorTest() {
        Actor actor = new Actor("1", "Förnamn", "Efternamn", LocalDate.of(1985, 8, 20));
        ActorService service = new ActorService(mockRepository);

        assertEquals(service.save(actor), "Actor saved");
        when(mockRepository.findActorByFirstNameAndLastName(actor.getFirstName(), actor.getLastName()))
        .thenReturn(actor);
        assertEquals(service.save(actor), "Actor already exists");
    }

    @Test
    public void actorListIsNotNull() {
        Actor actor = new Actor("1", "Förnamn", "Efternamn", LocalDate.of(1955, 02, 10));
        ActorService service = new ActorService(mockRepository);
        List<Actor> actorList = new ArrayList<>();
        actorList.add(actor);

        when(mockRepository.findAll()).thenReturn(actorList);
        assertNotNull(service.getAllActors());
        Collections.singletonList(actor);
    }

}