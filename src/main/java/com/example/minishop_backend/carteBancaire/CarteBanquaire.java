package com.example.minishop_backend.carteBancaire;

import jakarta.persistence.Entity;

public class CarteBanquaire {
    private Long id;
    private String type;

    public CarteBanquaire(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public CarteBanquaire(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarteBanquaire{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
