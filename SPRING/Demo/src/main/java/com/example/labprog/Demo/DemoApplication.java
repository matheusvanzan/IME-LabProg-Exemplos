package com.example.labprog.Demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/users")
    public ArrayList<User> usersAll() {
		UserManager manager = new UserManager();
		ArrayList<User> users = manager.getAll();
		return users;
    }

	@GetMapping("/users/{id}")
    public User usersById(@PathVariable("id") Integer id) {
		UserManager manager = new UserManager();
		User user = manager.getUserById(id);
		return user;
    }

}
