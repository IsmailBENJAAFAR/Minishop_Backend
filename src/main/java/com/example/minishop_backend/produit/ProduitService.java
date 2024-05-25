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
    public void updateProduit(
            Long id,
            String name,
            String category,
            float price,
            String brand,
            String description,
            int quantity
    ) {
        Produit oldProduit = produitRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + id + " does not exists"));
        if(name != null &&
                !name.isEmpty() &&
                !Objects.equals(oldProduit.getName(),name)){
            oldProduit.setName(name);
        }
        if(category != null &&
                !category.isEmpty() &&
                !Objects.equals(oldProduit.getCategory(),category)){
            oldProduit.setCategory(category);
        }
        if(price > 0 &&
                oldProduit.getPrice()!=price){
            oldProduit.setPrice(price);
        }
        if(brand != null &&
                !brand.isEmpty() &&
                !Objects.equals(oldProduit.getBrand(),brand)){
            oldProduit.setBrand(brand);
        }
        if(description != null &&
                !description.isEmpty() &&
                !Objects.equals(oldProduit.getDescription(),description)){
            oldProduit.setDescription(description);
        }
        if(quantity >= 0 &&
                oldProduit.getQuantity()!=quantity){
            oldProduit.setQuantity(quantity);
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
