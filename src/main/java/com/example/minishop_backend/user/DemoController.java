package com.example.minishop_backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("demo")
@RequiredArgsConstructor
public class DemoController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<User> register() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }
}
