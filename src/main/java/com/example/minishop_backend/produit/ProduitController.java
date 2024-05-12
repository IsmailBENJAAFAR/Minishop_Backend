package com.example.minishop_backend.produit;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produit")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @GetMapping
    public List<Produit> findProducts() {
        return produitService.getProduits();
    }
}
