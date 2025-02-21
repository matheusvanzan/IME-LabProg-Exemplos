package com.example.labprog.sessions;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SpringBootApplication
public class SessionsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SessionsApplication.class, args);
	}
}

@RestController
class SessionsController {

	@GetMapping("/")
    public Map<String, String> home() {
        String host = "http://localhost:8080";
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("store", host + "/store?sessionKey=yourKey&sessionValue=yourValue");
        endpoints.put("retrieve", host + "/retrieve");
        return endpoints;
    }

	@GetMapping("/store")
    public String storeSessionValue(@RequestParam String sessionKey, @RequestParam String sessionValue, final HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(sessionKey, sessionValue);
        return "Value stored in session with key: " + sessionKey;
    }

    @GetMapping("/retrieve")
    public Map<String, Object> retrieveSessionValue(final HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, Object> sessionAttributes = new HashMap<>();

        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String key = attributeNames.nextElement();
            sessionAttributes.put(key, session.getAttribute(key));
        }

        return sessionAttributes;
    }
}