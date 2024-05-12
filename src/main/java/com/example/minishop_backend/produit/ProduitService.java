package com.example.minishop_backend.produit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;

    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    public void addProduit(Produit produit) {

    }

    public void updateProduit(Long id) {

    }

    public void deleteProduit() {

    }

    public List<Produit> searchProduit() {
        return null;
    }
}
