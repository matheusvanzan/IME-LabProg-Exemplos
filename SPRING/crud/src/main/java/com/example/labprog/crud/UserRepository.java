package com.example.labprog.crud;

import org.springframework.data.repository.CrudRepository;

// A classe será implementada automaticamente pelo Spring
// Precisamos apenas criar a interface


public interface UserRepository extends CrudRepository<User, Integer> {

    // findAll() e save() não precisam ser declarados

    Iterable<User> findByFirstName(String name);

}