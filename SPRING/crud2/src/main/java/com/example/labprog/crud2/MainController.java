package com.example.labprog.crud2;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/users")
public class MainController {

    @GetMapping(path="/all")
    public HashMap<String, String> getAllUsers() {
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "ok");
        return response;
    }
}
