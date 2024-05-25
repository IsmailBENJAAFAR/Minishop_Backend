package com.example.minishop_backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PatchMapping("update")
    public ResponseEntity<User> updateUserInfo(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }
}
