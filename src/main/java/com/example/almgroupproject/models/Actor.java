package com.example.almgroupproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-17
 * Time: 14:13
 * Project: almGroupProject
 * Copyright: MIT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

}
