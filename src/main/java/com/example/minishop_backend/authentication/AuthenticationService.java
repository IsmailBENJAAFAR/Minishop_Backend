package com.example.minishop_backend.authentication;

import com.example.minishop_backend.jwt.JwtService;
import com.example.minishop_backend.user.Role;
import com.example.minishop_backend.user.User;
import com.example.minishop_backend.user.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(User request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());

        user.setRole(Role.USER);

        try {
            user = userRepository.save(user);
        } catch (ConstraintViolationException exception) {
            List<String> constraints =
                    exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            String message = String.join(", ", constraints);
            System.out.println(exception.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(User request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//            System.err.println(e.getMessage());
        }

        try {
            User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");
            String token = jwtService.generateToken(user);

            return new AuthenticationResponse(token);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
