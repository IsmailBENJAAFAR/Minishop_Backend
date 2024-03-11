package com.example.minishop_backend.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String login, String password) {
        Account account = new Account();
        account.setLogin(login);
        accountRepository.save(account);
    }
}
