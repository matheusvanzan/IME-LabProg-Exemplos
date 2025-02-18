package com.example.labprog.movies.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actor extends Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fictitiousName;

    public Actor() {}

    // Getters and Setters

    public String getFictitiousName() {
        return fictitiousName;
    }

    public void setFictitiousName(String fictitiousName) {
        this.fictitiousName = fictitiousName;
    }

    @Override
    public String toString() {
        return "Actor [fictitiousName=" + fictitiousName + "]";
    }
}

