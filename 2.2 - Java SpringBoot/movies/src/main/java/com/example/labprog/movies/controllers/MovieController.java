package com.example.labprog.movies.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.labprog.movies.entities.Actor;
import com.example.labprog.movies.entities.Director;
import com.example.labprog.movies.entities.Movie;
import com.example.labprog.movies.repositories.ActorRepository;
import com.example.labprog.movies.repositories.DirectorRepository;
import com.example.labprog.movies.repositories.MovieRepository;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(path="/movies")
public class MovieController {

    
    @Autowired
    MovieRepository movieRepository;
    
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    DirectorRepository directorRepository;


    @PostConstruct
    public void createDB() {

        if (movieRepository.findAll().isEmpty()) {

            // Create some actors
            Actor actor1 = new Actor();
            actor1.setFirstName("John");
            actor1.setLastName("Doe");
            actor1.setFictitiousName("Johnny D");
            actorRepository.save(actor1);

            Actor actor2 = new Actor();
            actor2.setFirstName("Jane");
            actor2.setLastName("Smith");
            actor2.setFictitiousName("Janie S");
            actorRepository.save(actor2);

            // Create a director
            Director director = new Director();
            director.setFirstName("Michael");
            director.setLastName("Johnson");
            directorRepository.save(director);

            // Create some movies
            Movie movie1 = new Movie();
            movie1.setTitle("The Great Adventure");
            Set<Actor> actors1 = new HashSet<>();
            actors1.add(actor1);
            actors1.add(actor2);
            movie1.setActors(actors1);
            movie1.setDirector(director);
            movieRepository.save(movie1);

            Movie movie2 = new Movie();
            movie2.setTitle("Mystery of the Unknown");
            Set<Actor> actors2 = new HashSet<>();
            actors2.add(actor1);
            movie2.setActors(actors2);
            movie2.setDirector(director);
            movieRepository.save(movie2);

        }


    }

    // R - READ - GET
    @GetMapping(path="/all")
    public List<Movie> getAllUsers() {
        return movieRepository.findAll();
    }

}
