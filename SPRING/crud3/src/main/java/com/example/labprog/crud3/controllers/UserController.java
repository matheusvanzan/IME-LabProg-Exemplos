package com.example.labprog.crud3.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.labprog.crud3.entities.User;
import com.example.labprog.crud3.repositories.UserRepository;
import com.example.labprog.crud3.services.UserService;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost")
@RestController
public class UserController {

    @Autowired // repositório criado automaticamente pelo Spring
    private UserRepository userRepository;

    private UserService userService;

    // public UserController() {
    //     Aqui o userRepository ainda não está disponível.
    // }

    @PostConstruct
    public void initialize() {
        userService = new UserService(userRepository);
    }

    // R - READ - GET
    @GetMapping(path="/all")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }
    
    @GetMapping(path="/search/{username}")
    public User searchUserByUsername(@PathVariable("username") String username) {        
        return userService.findByUsername(username);
    }

    // C - CREATE - POST
    @PostMapping("/create")
    public HashMap<String, Object> create(
        @RequestParam(defaultValue = "") String username, 
        @RequestParam(defaultValue = "") String password ) {

        String returnStatus = "";
        User newUser = null;
        
        if (username.equals("") || password.equals("")) {
            returnStatus = "Erro!";
        }

        newUser = userService.createUser(username, password);
        returnStatus = "User created";

        HashMap<String, Object> response = new HashMap<>();
        response.put("status", returnStatus);
        response.put("user", newUser);
        return response;
    }
    
    // U - UPDATE - PUT
    @PutMapping(path="/update/{id}")
    public HashMap<String, Object> updateUserById(
        @PathVariable("id") Integer id, 
        @RequestParam String username) {  

        String returnStatus = "";
        User newUser = null;
            
        if (username.equals("")) {
            returnStatus = "Erro!";
        }

        newUser = userService.updateUsername(id, username);
        returnStatus = "User created";

        HashMap<String, Object> response = new HashMap<>();
        response.put("status", returnStatus);
        response.put("user", newUser);
        return response;     
    }

    // D - DELETE - DELETE
    @DeleteMapping(path="delete/{id}")
    public Boolean deleteUserById(@PathVariable("id") Integer id) {
        return userService.deleteUser(id);
    }
}