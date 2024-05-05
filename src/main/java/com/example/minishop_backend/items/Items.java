package com.example.minishop_backend.items;

import com.example.minishop_backend.commande.Commande;
import com.example.minishop_backend.produit.Produit;
import jakarta.persistence.*;

@Entity
@Table
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Quantity;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
    @OneToOne
    @JoinColumn(name = "produit_id",referencedColumnName = "id")
    private Produit produit;
    public Items() {
    }

    public Items(Long id, int quantity) {
        this.id = id;
        Quantity = quantity;
    }

    public Items(int quantity) {
        Quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", Quantity=" + Quantity +
                '}';
    }
}
