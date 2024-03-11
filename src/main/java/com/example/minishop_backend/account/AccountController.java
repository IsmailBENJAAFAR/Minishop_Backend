package com.example.minishop_backend.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService createAccountService;

    @Autowired
    public AccountController(AccountService createAccountService) {
        this.createAccountService = createAccountService;
    }
    @GetMapping("/testCreate")
    public String hello() {
        createAccountService.createAccount("soufiane", "samini");

        return "Hello, i've created a test account";
    }
}
