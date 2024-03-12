package com.example.minishop_backend.authentication;

import com.example.minishop_backend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RequestMapping(value = "/auth", consumes = "application/json", produces = "application/json")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }
}
