package com.example.minishop_backend.controllers;

import com.example.minishop_backend.services.CreateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final CreateAccountService createAccountService;

    @Autowired
    public HelloController(CreateAccountService createAccountService) {
        this.createAccountService = createAccountService;
    }
    @GetMapping("/hello")
    public String hello() {
        createAccountService.createAccount("soufiane", "samini");

        return "Hello, i've created a test account";
    }
}
