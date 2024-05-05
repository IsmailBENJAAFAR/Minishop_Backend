package com.example.minishop_backend.notation;

public class Notation {
    private Long id;
    private int etoiles;

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

    @Override
    public String toString() {
        return "Notation{" +
                "id=" + id +
                ", etoiles=" + etoiles +
                '}';
    }
}