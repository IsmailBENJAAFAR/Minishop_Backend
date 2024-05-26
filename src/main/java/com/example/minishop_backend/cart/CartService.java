package com.example.minishop_backend.cart;

import com.example.minishop_backend.produit.Produit;
import com.example.minishop_backend.produit.ProduitService;
import com.example.minishop_backend.user.User;
import com.example.minishop_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class CartService {
    private final UserService userService;
    private final ProduitService produitService;
    private final Map<Long, Cart> userCarts = new HashMap<>();

    public List<Produit> getProduitsInCart() {
        User currentUser = userService.getCurrentUser();
        if (!userCarts.containsKey(currentUser.getId()))
            return List.of();

        List<Long> produitsIds = userCarts.get(currentUser.getId()).getProductIds();

        return produitService.getProduits().stream().filter(
                produit -> produitsIds.contains(produit.getId())
        ).toList();
    }

    public List<Produit> addProductToCart(Long id) {
        User currentUser = userService.getCurrentUser();
        if (userCarts.get(currentUser.getId()) == null)
            userCarts.put(currentUser.getId(), new Cart());

        List<Long> productIds = userCarts.get(currentUser.getId()).getProductIds();
        if (!productIds.contains(id))
            productIds.add(id);

        return getProduitsInCart();
    }

    public List<Produit> clearCart() {
        User currentUser = userService.getCurrentUser();
        userCarts.remove(currentUser.getId());

        return List.of();
    }
}
