package com.example.minishop_backend.carteBancaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteBanquaireRepository extends JpaRepository<CarteBanquaire,Long> {
}
