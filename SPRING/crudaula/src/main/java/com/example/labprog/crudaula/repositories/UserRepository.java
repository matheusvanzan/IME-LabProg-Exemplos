package com.example.labprog.crudaula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labprog.crudaula.entities.UserEntity;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {

    // findAll(), findById()

    UserEntity findByUsername(String usermane);

}
