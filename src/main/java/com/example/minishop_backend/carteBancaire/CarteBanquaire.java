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
    private String rib;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public CarteBanquaire() {
    }

    public CarteBanquaire(Long id, String type, String rib) {
        this.id = id;
        this.type = type;
        this.rib = rib;
    }

    public CarteBanquaire(String type, String rib) {
        this.type = type;
        this.rib = rib;
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

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CarteBanquaire{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", rib='" + rib + '\'' +
                '}';
    }
}
