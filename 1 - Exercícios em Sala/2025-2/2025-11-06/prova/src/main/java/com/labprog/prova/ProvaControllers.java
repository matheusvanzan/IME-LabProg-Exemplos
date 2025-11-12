package com.labprog.prova;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvaControllers {

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("Status", "Ok");
        return response;
    }
}