package com.example.minishop_backend.utils;

import com.example.minishop_backend.produit.Produit;
import com.example.minishop_backend.produit.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {
    private final ProduitRepository produitRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Produit> produits = List.of(
                new Produit(1L, "Pizza Family", "salty", 70, "Domino's", "A classic pizza with a variety of toppings", 4),
                new Produit(2L, "Sushi Deluxe", "sweet", 40, "Wasabi", "A premium sushi set with fresh fish and vegetables", 3),
                new Produit(3L, "Tacos Fiesta", "salty", 50, "Taco Bell", "A flavorful taco set with a variety of toppings and sides", 2),
                new Produit(4L, "Burgers Classic", "salty", 60, "McDonald's", "A classic burger with a variety of toppings and condiments", 1),
                new Produit(5L, "Salad Fresh", "sweet", 30, "Wendy's", "A fresh salad with a variety of toppings and dressings", 1),
                new Produit(6L, "Wings Spicy", "salty", 80, "KFC", "A spicy set of chicken wings with a variety of sauces", 3),
                new Produit(7L, "Sandwich Club", "salty", 45, "Subway", "A club sandwich with turkey, ham, and cheese", 2),
                new Produit(8L, "Fries Golden", "sweet", 20, "Arby's", "A set of crispy fries with a variety of toppings", 1),
                new Produit(9L, "Desserts Creamy", "sweet", 90, "Dairy Queen", "A set of creamy desserts with a variety of flavors and toppings", 1),
                new Produit(10L, "Soup Hearty", "salty", 25, "Panera Bread", "A hearty set of soups with a variety of flavors and toppings", 2)
        );
        produitRepository.saveAll(produits);
    }
}
