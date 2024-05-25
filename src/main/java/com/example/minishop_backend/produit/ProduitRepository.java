package com.example.minishop_backend.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduitRepository
        extends JpaRepository<Produit, Long> {
    @Query("SELECT p FROM Produit p Where p.name = ?1")
    Optional<Produit> findProductByName(String name);
}
