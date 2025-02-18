package com.example.labprog.movies.entities;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    private String firstName;
    private String lastName;

    public Person() {}

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
