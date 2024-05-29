package com.example.minishop_backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PatchMapping("update")
    public ResponseEntity<User> updateUserInfo(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping()
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }
    @PostMapping("favorise")
    public void favoriseProduct(@RequestParam(required = true) Long product_id){
        userService.favorise(userService.getCurrentUser(),product_id);
    }
}
