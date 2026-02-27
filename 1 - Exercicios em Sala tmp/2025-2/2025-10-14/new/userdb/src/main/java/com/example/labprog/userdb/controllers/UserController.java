package com.example.labprog.userdb.controllers;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.labprog.userdb.entities.User;
import com.example.labprog.userdb.repositories.UserRepository;
import com.example.labprog.userdb.services.UserService;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    public HashMap<String, String> createUser(@RequestParam String username) {
        User user = new User();
        user.setUsername(username);
        userRepository.save(user);

        HashMap<String, String> response = new HashMap<>();
        response.put("Status", "Ok");
        return response;
    }

    @GetMapping("list")
    public Iterable<User> listALl() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @PutMapping("update/{id}")
    public User updateById(@PathVariable("id") Integer id, 
                           @RequestParam String newUsername) {

        // obter um referencia para o User, pelo Id
        Optional<User> optUser = userRepository.findById(id); // busca no BD se existir, se nao deixa "vazio"
        if (optUser.isPresent()) { // verifica se esta vazio ou não
            User user = optUser.get(); // realmente obtenho uma instancia do User
            user.setUsername(newUsername);

            userRepository.save(user);
            return user;
        }

        return new User();
    }

}
