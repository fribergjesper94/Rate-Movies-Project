package com.example.almgroupproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-05-17
 * Time: 14:23
 * Project: almGroupProject
 * Copyright: MIT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    @Id
    private int id;

    private String firstName;
    private String lastName;
    private String gender;

}
