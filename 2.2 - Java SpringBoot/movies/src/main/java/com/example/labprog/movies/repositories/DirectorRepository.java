package com.example.labprog.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labprog.movies.entities.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    // Custom query methods can be defined here if needed
}
