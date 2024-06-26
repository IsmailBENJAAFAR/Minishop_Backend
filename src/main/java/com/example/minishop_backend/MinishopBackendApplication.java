package com.example.minishop_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class MinishopBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinishopBackendApplication.class, args);
    }

}
