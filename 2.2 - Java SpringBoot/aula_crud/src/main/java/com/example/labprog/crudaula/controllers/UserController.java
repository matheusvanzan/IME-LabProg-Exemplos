package com.example.labprog.crudaula.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.labprog.crudaula.entities.UserEntity;
import com.example.labprog.crudaula.repositories.UserRepository;
import com.example.labprog.crudaula.services.UserService;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {

    @Autowired // repositório criado automaticamente pelo Spring
    private UserRepository userRepository;
    UserService userService;

    @PostConstruct
    public void initialize() {
        userService = new UserService(userRepository);
    }

    // C - CREATE
    @PostMapping("/create")
    public HashMap<String, String> create(
        @RequestParam(defaultValue = "") String username,
        @RequestParam(defaultValue = "") String password ) {

        // Validação de dados de entrada
        // Cifragem da senha (por enquanto)

        userService.createUser(username, password);

        HashMap<String, String> response = new HashMap<>();
        response.put("username", username);
        response.put("password", password);
        return response;
    }

    // R - READ
    @GetMapping("/all")
    public Iterable<UserEntity> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/search/{username}")
    public UserEntity searchUserByUsername(
        @PathVariable("username") String username) {   
        return userService.findByUsername(username);
    }
    
    // U - UPDATE
    @PutMapping("/update/{id}")
    public UserEntity updateUser(
        @PathVariable("id") Long id, 
        @RequestParam String username) {

        return userService.updateUsername(id, username);
    }
    

}
