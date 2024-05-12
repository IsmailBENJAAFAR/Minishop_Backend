package com.example.minishop_backend.produit;

import com.example.minishop_backend.discount.Discount;
import com.example.minishop_backend.image.Image;
import com.example.minishop_backend.items.Items;
import com.example.minishop_backend.notation.Notation;
import com.example.minishop_backend.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private float price;
    private String brand;
    private String description;
    private int quantity;
    @OneToMany(mappedBy = "produit")
    private List<Image> images;
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @OneToOne(mappedBy = "produit")
    private Items items;
    @ManyToMany(mappedBy = "produits")
    private List<Notation> notations;
    @ManyToMany(mappedBy = "produits")
    private List<User> users;

    public Produit() {
    }

    public Produit(Long id,
                   String name,
                   String category,
                   float price,
                   String brand,
                   String description,
                   int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.quantity = quantity;
    }

    public Produit(String name,
                   String category,
                   float price,
                   String brand,
                   String description,
                   int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

