package com.example.labprog.onepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OnepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnepageApplication.class, args);
	}

	@GetMapping("/home")
    public String home() {
		return "Welcome home!";
    }

}
