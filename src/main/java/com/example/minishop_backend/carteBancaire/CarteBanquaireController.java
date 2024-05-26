package com.example.minishop_backend.carteBancaire;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(path = "cartebancaire")
@RequiredArgsConstructor
public class CarteBanquaireController {
    private final CarteBanquaireRepository carteBanquaireRepository;
}
