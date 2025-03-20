package com.example.labprog.fatorial.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.labprog.fatorial.entities.FatorialEntity;

@RestController
public class HomeController {

    @GetMapping("/fatorial/{id}")
    public ApiResponse home(@PathVariable("id") Integer number) {

        FatorialEntity fatorialEntity = new FatorialEntity(number);

        ApiResponse response = new ApiResponse(
            "Estou na home", 
            fatorialEntity
        );

        return response;
    }    

}

