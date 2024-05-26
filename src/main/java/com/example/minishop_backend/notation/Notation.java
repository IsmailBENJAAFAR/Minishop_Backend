package com.example.minishop_backend.notation;

import com.example.minishop_backend.produit.Produit;
import com.example.minishop_backend.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Notation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int etoiles;
    @ManyToMany
    @JoinTable(name = "Notation_Produit")
    private List<Produit> produits;
    @ManyToMany
    @JoinTable(name = "Notation_User")
    private List<User> users;

    public Notation() {
    }

    public Notation(Long id, int etoiles) {
        this.id = id;
        this.etoiles = etoiles;
    }

    public Notation(int etoiles) {
        this.etoiles = etoiles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Notation{" +
                "id=" + id +
                ", etoiles=" + etoiles +
                '}';
    }
}