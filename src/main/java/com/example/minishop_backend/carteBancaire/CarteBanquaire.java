package com.example.minishop_backend.carteBancaire;

import com.example.minishop_backend.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "carte_banquaire")
public class CarteBanquaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public CarteBanquaire() {
    }

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
