package com.example.minishop_backend.items;

public class Items {
    private Long id;
    private int Quantity;

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
