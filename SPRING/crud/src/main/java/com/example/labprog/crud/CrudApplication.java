package com.example.labprog.crud;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
		System.out.println("CrudApplication main args: " + Arrays.toString(args)); // [--server.port=8090, --createdb=true]
	}
}
