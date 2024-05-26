package com.example.minishop_backend.items;

import com.example.minishop_backend.commande.Commande;
import com.example.minishop_backend.produit.Produit;
import jakarta.persistence.*;

@Entity
@Table
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
    @OneToOne
    @JoinColumn(name = "produit_id", referencedColumnName = "id")
    private Produit produit;

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Items() {
    }

    public Items(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Items(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", Quantity=" + quantity +
                '}';
    }
}
