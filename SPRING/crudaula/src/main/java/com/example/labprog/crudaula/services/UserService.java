package com.example.labprog.crudaula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.labprog.crudaula.entities.UserEntity;
import com.example.labprog.crudaula.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }

    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity updateUsername(Long id, String username) {

        Optional<UserEntity> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();

            user.setUsername(username);
            userRepository.save(user);
            return user;
        } 

        return new UserEntity();
    }

}
