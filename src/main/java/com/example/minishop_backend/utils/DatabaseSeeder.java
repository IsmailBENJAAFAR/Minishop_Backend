package com.example.minishop_backend.utils;

import com.example.minishop_backend.image.Image;
import com.example.minishop_backend.image.ImageRepository;
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
    private final ImageRepository imageRepository;

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
        List<Produit> result = produitRepository.saveAll(produits);

        List<String> urls = List.of(
                "https://kauveryhospital.com/blog/wp-content/uploads/2021/04/pizza-5179939_960_720.jpg",
                "https://www.cookwithmanali.com/wp-content/uploads/2021/04/Vegan-Sushi-500x500.jpg",
                "https://www.allrecipes.com/thmb/4AbbUJe3vFzftNyAwCXW2nhDbjM=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/5281437-a5d6b201a7274183b1501b41c04e4b0f.jpg",
                "https://lacuisineensemble.fr/wp-content/uploads/2022/02/recette-burger-maison-500x500.jpg",
                "https://www.refreshmyhealth.com/wp-content/uploads/2020/07/how-to-make-a-simple-salad-recipe-vegan-gluten-free-lunch_260-main_img_6804-lrcc.jpg",
                "https://savorwithjennifer.com/wp-content/uploads/2022/06/Extra-Crispy-Sweet-and-Spicy-Wings-on-the-Grill-1-2.jpg",
                "https://tornadoughalli.com/wp-content/uploads/2022/05/CLUB-SANDWICH-RECIPE-3-2.jpg",
                "https://static.toiimg.com/thumb/54659021.cms?imgsize=275086&width=800&height=800",
                "https://www.tasteofhome.com/wp-content/uploads/0001/01/Fried-Ice-Cream-Dessert-Bars-_EXPS_SDJJ19_232652_B02_06_1b_rms.jpg",
                "https://res.cloudinary.com/hksqkdlah/image/upload/4811_sfs-wintervegetablesoup-316239.jpg"
        );
        List<Image> images = result.stream().map(produit -> {
            var image = new Image();
            image.setId(produit.getId());
            image.setUrl(urls.get(produit.getId().intValue() - 1));
            image.setProduit(produit);

            return image;
        }).toList();
        imageRepository.saveAll(images);
    }
}
