package com.example.labprog.movies.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Director extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public Director() {}

    // Getters and Setters

    @Override
    public String toString() {
        return "Director []";
    }

}
