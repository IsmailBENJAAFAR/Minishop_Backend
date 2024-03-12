package com.example.minishop_backend.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DemoController {
    @GetMapping("/demo")
    public ResponseEntity<String> register() {
        Authentication holder = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) holder.getPrincipal();
        return ResponseEntity.ok("You are secure " + user.getUsername() + " your id is: " + user.getId());
    }
}
