package com.example.almgroupproject.service;

import com.example.almgroupproject.models.Director;
import com.example.almgroupproject.repositories.DirectorRepository;
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
public class DirectorService {
    private final DirectorRepository repository;

    public List<Director> getAllDirectors() {
        return repository.findAll();
    }

    public String save(Director director) {

        if (repository.findDirectorByFirstNameAndLastName(director.getFirstName(), director.getLastName()) != null) {
            return "Director already exists";
        }

        repository.save(director);
        return "Director saved";
    }
}
