package com.example.minishop_backend.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public interface ProduitRepository
        extends JpaRepository<Produit, Long> {
    @Query("SELECT p FROM Produit p Where p.name = ?1 and p.brand = ?2")
    Optional<Produit> isExist(String name,String brand);
    @Query("SELECT p FROM Produit p Where p.name = ?1")
    List<Produit> findProductByName(String name);
    @Query("SELECT p FROM Produit p Where p.brand = ?1")
    List<Produit> findProductByBrand(String brand);
    @Query("SELECT p FROM Produit p Where p.category = ?1")
    List<Produit> findProductByCategory(String category);
    @Query("SELECT p FROM Produit p Where p.price >= ?1 and p.price <= ?2")
    List<Produit> findProductByPrice(float lowerPrice, float higherPrice);
}
