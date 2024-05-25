package com.example.minishop_backend.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitRepository
        extends JpaRepository<Produit, Long> {

}
