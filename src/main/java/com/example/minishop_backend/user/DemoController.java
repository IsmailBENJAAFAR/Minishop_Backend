package com.example.minishop_backend.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DemoController {
    @GetMapping("/demo")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok("You are secure");
    }
}
