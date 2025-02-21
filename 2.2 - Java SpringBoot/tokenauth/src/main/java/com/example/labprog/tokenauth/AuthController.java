package com.example.labprog.tokenauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.labprog.tokenauth.entities.User;
import com.example.labprog.tokenauth.repositories.UserRepository;
import com.example.labprog.tokenauth.services.UserService;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired // repositório criado automaticamente pelo Spring
    private UserRepository userRepository;

    private UserService userService;

    // public AuthController() {
    //     Aqui o userRepository ainda não está disponível.
    // }

    @PostConstruct
    public void initialize() {
        System.out.println("initialize");
        System.out.println(userRepository);
        userService = new UserService(userRepository);
    }

    @GetMapping("/")
    public String home1() {
        return "home1";
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        System.out.println("getUsers");
        System.out.println(userRepository);
        System.out.println(userService);
        return userService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
        @RequestParam String username,
        @RequestParam String email,
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam String password,
        @RequestParam boolean isAdmin) {
            
        User user = userService.registerUser(username, email, firstName, lastName, password, isAdmin);
        return ResponseEntity.ok("User registered successfully with ID: " + user.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
        @RequestParam String username,
        @RequestParam String password) {

        Optional<User> userOptional = userService.findUserByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getPassword().equals(password)) {

                user = userService.generateAndStoreAuthToken(user);
                return ResponseEntity.ok("Login successful. Token: " + user.getAuthToken());
            }
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

    @PostMapping("/validate-token")
    public ResponseEntity<String> validateToken(
        @RequestParam String username,
        @RequestParam String token) {

        Optional<User> userOptional = userService.findUserByUsername(username);
        if (!userOptional.isPresent()) {
            return ResponseEntity.status(404).body("User not found");
        }

        User user = userOptional.get();
        if (token.equals(user.getAuthToken()) && userService.isAuthTokenValid(user)) {
            return ResponseEntity.ok("Token is valid");

        } else {
            return ResponseEntity.status(401).body("Token is expired or invalid");
        }        
    }
}
