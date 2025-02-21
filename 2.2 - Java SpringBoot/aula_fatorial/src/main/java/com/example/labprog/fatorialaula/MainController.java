package com.example.labprog.fatorialaula;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.labprog.fatorialaula.entities.FatorialEntity;

@RestController
public class MainController {

    @GetMapping("/home")
    public HashMap<String, String> home() {

        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Estou na home");
        response.put("status", "Ok");
        return response;
    }

    @PostMapping("/fatorial")
    public ApiResponse getFatorial(
        @RequestParam(defaultValue = "1") Integer number) {   
        
        FatorialEntity fat = new FatorialEntity(number);
        ApiResponse response2 = new ApiResponse("ok", fat);
        return response2;
    }
    

}
