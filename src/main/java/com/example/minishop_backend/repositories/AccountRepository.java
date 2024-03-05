package com.example.minishop_backend.repositories;

import com.example.minishop_backend.entities.Account;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface AccountRepository extends Repository<Account, Long> {
    Account save(Account account);
    Optional<Account> findById(int id);
}
