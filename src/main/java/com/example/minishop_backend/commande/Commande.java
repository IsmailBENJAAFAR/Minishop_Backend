package com.example.minishop_backend.commande;

import java.util.Date;

public class Commande {
    private Long id ;
    private Date date;

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
