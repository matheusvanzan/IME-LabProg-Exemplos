package com.example.labprog.crud;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/users") // Todas as URL iniciam com /users
public class MainController {

    @Autowired // repositório criado automaticamente pelo Spring
    private UserRepository userRepository;

    // C - CREATE - POST
    @PostMapping(path="/create")
    public HashMap<String, String> addNewUser (
        @RequestParam String username, 
        @RequestParam String email, 
        @RequestParam String firstName,
        @RequestParam String lastName) {

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        userRepository.save(newUser);

        HashMap<String, String> response = new HashMap<>();
        response.put("status", "ok");
        response.put("message", "User created");
        return response;
    }

    // R - READ - GET
    @GetMapping(path="/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @GetMapping(path="/search/{username}")
    public Iterable<User> searchUserByUsername(@PathVariable("username") String username) {        
        return userRepository.findByUsername(username);
    }

    // U - UPDATE - PUT
    @PutMapping(path="/update/{id}")
    public User updateUserById(@PathVariable("id") Integer id, 
        @RequestParam String firstName, 
        @RequestParam String lastName) {        
        
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println(user);

            user.setFirstName(firstName);
            user.setLastName(lastName);
            userRepository.save(user);

            return user;
        }

        return new User();
    }


    // D - DELETE - DELETE
    @DeleteMapping(path="delete/{id}")
    public Boolean deleteUserById(@PathVariable("id") Integer id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return true;
        }

        return false;
    }
}