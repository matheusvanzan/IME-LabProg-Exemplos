package com.example.labprog.tokenauth.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.labprog.tokenauth.entities.User;
import com.example.labprog.tokenauth.repositories.UserRepository;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        System.out.println("UserService");
        System.out.println(userRepository);
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User registerUser(String username, String email, String firstName, String lastName, String password, boolean isAdmin) {
        User user = new User(username, email, firstName, lastName, password, LocalDateTime.now(), null, null, null, isAdmin, true);
        return userRepository.save(user);
    }

    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    public User updateUserLastLogin(User user) {
        user.setLastLogin(LocalDateTime.now());
        return userRepository.save(user);
    }

    public void deactivateUser(User user) {
        user.setActive(false);
        userRepository.save(user);
    }

    public User generateAndStoreAuthToken(User user) {
        String token = UUID.randomUUID().toString().replace("-", "");
        LocalDateTime expirationDate = LocalDateTime.now().plusDays(1); // Token valid for 1 day
        user.setAuthToken(token);
        user.setAuthTokenExpiration(expirationDate);
        return userRepository.save(user);
    }

    public boolean isAuthTokenValid(User user) {
        if (user.getAuthToken() == null || user.getAuthTokenExpiration() == null) {
            return false;
        }
        return LocalDateTime.now().isBefore(user.getAuthTokenExpiration());
    }
}
