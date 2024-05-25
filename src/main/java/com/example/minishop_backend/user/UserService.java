package com.example.minishop_backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public User updateUser(User request) {
        User currentUser = getCurrentUser();
        request.setId(currentUser.getId());
        request.setPassword(currentUser.getPassword());
        request.setUsername(currentUser.getUsername());
        request.setRole(currentUser.getRole());

        if (request.getAddress() == null)
            request.setAddress(currentUser.getAddress());
        if (request.getEmail() == null)
            request.setEmail(currentUser.getEmail());
        if (request.getPassword() == null)
            request.setPassword(currentUser.getPassword());
        else request.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(request);
    }
}
