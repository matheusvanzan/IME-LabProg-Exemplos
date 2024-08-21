package com.example.labprog.users;

import java.util.ArrayList;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

}

@RestController
class UsersController {

    @GetMapping("/users") // http://localhost:8080/users
    public ApiResponse<ArrayList<User>> usersAll() {
        UserManager manager = new UserManager();
        ArrayList<User> users = manager.getAll();
        String message = "List of all users";
        return new ApiResponse<>(users, message);
    }

    @GetMapping("/users/{id}") // http://localhost:8080/users/2
    public ApiResponse<User> usersById(@PathVariable("id") Integer id) {
        UserManager manager = new UserManager();
        User user = manager.getUserById(id);
        String message = "User details";

		if (user == null) {
			message = "Erro!";
		}
        return new ApiResponse<>(user, message);
    }
}
