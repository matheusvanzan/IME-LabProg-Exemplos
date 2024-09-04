package com.example.labprog.crud3.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.labprog.crud3.entities.User;
import com.example.labprog.crud3.repositories.UserRepository;


public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User createUser(String username, String password) {
        // aqui eu poderia:
        // - fazer um hash da senha
        // - conferir username duplicado

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User updateUsername(Integer id, String username) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {

            User user = userOptional.get();
            user.setUsername(username);
            userRepository.save(user);
            return user;
        }

        return new User();
    }

    public boolean deleteUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return true;
        }

        return false;
    }
}
