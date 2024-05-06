package com.example.minishop_backend.commande;

import com.example.minishop_backend.items.Items;
import com.example.minishop_backend.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
@Entity
@Table
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(mappedBy = "commande")
    private ArrayList<Items> items;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;
    public Commande() {
    }

    public Commande(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Commande(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
