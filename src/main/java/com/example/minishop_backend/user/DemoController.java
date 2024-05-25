package com.example.minishop_backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class DemoController {
    private final UserService userService;

    @GetMapping("/demo")
    public ResponseEntity<User> register() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }
}
