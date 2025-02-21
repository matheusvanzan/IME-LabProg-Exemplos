package com.example.labprog.fatorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class FatorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(FatorialApplication.class, args);
	}
}

@RestController
class FatorialController {

	@GetMapping("/fat")
    public String calculateFactorial(@RequestParam(value = "n", defaultValue = "1") int n) {
		
		if (n < 0) {
            return "Factorial is not defined for negative numbers.";
        }
        return "Fatorial de " + n + " is " + factorial(n);
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
