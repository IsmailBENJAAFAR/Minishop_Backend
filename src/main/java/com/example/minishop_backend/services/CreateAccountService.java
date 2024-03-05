package com.example.minishop_backend.services;

import com.example.minishop_backend.entities.Account;
import com.example.minishop_backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public CreateAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String login, String password) {
        Account account = new Account();
        account.setLogin(login);
        accountRepository.save(account);
    }
}
