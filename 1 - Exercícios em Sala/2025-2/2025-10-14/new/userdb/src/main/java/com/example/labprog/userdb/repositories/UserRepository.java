package com.example.labprog.userdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labprog.userdb.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // find(), findAll(), finfById

    User findByUsername(String username);

}
