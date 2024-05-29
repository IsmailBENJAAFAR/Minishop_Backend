package com.example.minishop_backend.cart;

import com.example.minishop_backend.items.Items;
import com.example.minishop_backend.items.ItemsService;
import com.example.minishop_backend.produit.Produit;
import com.example.minishop_backend.produit.ProduitService;
import com.example.minishop_backend.user.User;
import com.example.minishop_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class CartService {
    private final UserService userService;
    private final ProduitService produitService;
    private final Map<Long, List<Items>> userCarts = new HashMap<>();

    public List<Items> getItemsInCart() {
        User currentUser = userService.getCurrentUser();
        if (!userCarts.containsKey(currentUser.getId()))
            return List.of();

        return userCarts.get(currentUser.getId());
    }

    public List<Items> addItemsToCart(Long productId, int quantity) {
        if (quantity <= 0)
            return getItemsInCart();

        Items items = new Items();
        Produit produit = produitService.getProduit(productId);
        items.setQuantity(quantity);
        items.setProduit(produit);

        User currentUser = userService.getCurrentUser();
        userCarts.computeIfAbsent(currentUser.getId(), k -> new ArrayList<>());

        List<Items> itemsList = userCarts.get(currentUser.getId());
        if (itemsList.stream()
                .noneMatch(items1 -> items1.getProduit().getId().equals(items.getProduit().getId())))
            itemsList.add(items);

        return getItemsInCart();
    }

    public List<Items> clearCart() {
        User currentUser = userService.getCurrentUser();
        userCarts.remove(currentUser.getId());

        return List.of();
    }
}
