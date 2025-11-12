package com.example.labprog.userdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.example.labprog.userdb.entities.User;
import com.example.labprog.userdb.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(String username) {
        // Verificar se o usuário já existe

        // Cria realmente o usuario
        User user = new User();
        user.setUsername(username);
        return userRepository.save(user);
    }

    public Iterable<User> listUsers() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

}
