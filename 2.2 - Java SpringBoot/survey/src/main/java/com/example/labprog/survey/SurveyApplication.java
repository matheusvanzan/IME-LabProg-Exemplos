package com.example.labprog.survey;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost")
@SpringBootApplication
@RestController
public class SurveyApplication {

	@Autowired
	private HttpServletRequest request;

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}

	@PostMapping("/")
    public String home() {
		String response = "";
		Map<String, String[]> map = request.getParameterMap();
		for (Object key: map.keySet()) {

            String keyStr = (String) key;
            String[] value = (String[]) map.get(keyStr);
            response += keyStr + " : " + Arrays.toString(value) + "\n";
    	}
        return response;
    }

}
