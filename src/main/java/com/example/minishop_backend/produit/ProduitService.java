package com.example.minishop_backend.produit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;

    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    public void addProduit(Produit produit) {
        Optional<Produit> produitByName = produitRepository.findProductByName(produit.getName());

        if (produitByName.isPresent()){
            throw new IllegalStateException("name taken");
        }
        produitRepository.save(produit);

    }
    @Transactional
    public void updateProduit(Produit produit) {
        Produit oldProduit = produitRepository.findById(produit.getId())
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + produit.getId() + " does not exists"));
        if(produit.getName() != null &&
                !produit.getName().isEmpty() &&
                !Objects.equals(oldProduit.getName(),produit.getName())){
            oldProduit.setName(produit.getName());
        }
        if(produit.getCategory() != null &&
                !produit.getCategory().isEmpty() &&
                !Objects.equals(oldProduit.getCategory(),produit.getCategory())){
            oldProduit.setCategory(produit.getCategory());
        }
        if(produit.getPrice() > 0 &&
                oldProduit.getPrice()!=produit.getPrice()){
            oldProduit.setPrice(produit.getPrice());
        }
        if(produit.getBrand() != null &&
                !produit.getBrand().isEmpty() &&
                !Objects.equals(oldProduit.getBrand(),produit.getBrand())){
            oldProduit.setBrand(produit.getBrand());
        }
        if(produit.getDescription() != null &&
                !produit.getDescription().isEmpty() &&
                !Objects.equals(oldProduit.getDescription(),produit.getDescription())){
            oldProduit.setDescription(produit.getDescription());
        }
        if(produit.getQuantity() >= 0 &&
                oldProduit.getQuantity()!=produit.getQuantity()){
            oldProduit.setQuantity(produit.getQuantity());
        }
    }

    public void deleteProduit(Long id) {
        boolean exists = produitRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("product with id " + id + " does not exists");
        }
        produitRepository.deleteById(id);
    }

    public List<Produit> searchProduit() {
        return null;
    }

}
