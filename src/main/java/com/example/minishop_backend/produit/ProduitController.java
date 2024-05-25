package com.example.minishop_backend.produit;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @GetMapping("products")
    public List<Produit> findProducts() {
        return produitService.getProduits();
    }

    @PostMapping(path = "adminOnly/new")
    public void registerNewProduct(@RequestBody Produit produit){
        produitService.addProduit(produit);
    }
}
