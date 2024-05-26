package com.example.minishop_backend.cart;

import com.example.minishop_backend.produit.Produit;
import com.example.minishop_backend.user.User;
import com.example.minishop_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping()
    public ResponseEntity<List<Produit>> getCart() {
        return ResponseEntity.ok(cartService.getProduitsInCart());
    }

    @PostMapping("add/{productId}")
    public ResponseEntity<List<Produit>> addToCart(@PathVariable("productId") Long id) {
        return ResponseEntity.ok(cartService.addProductToCart(id));
    }

    @PostMapping("clear")
    public ResponseEntity<List<Produit>> clearCart() {
        return ResponseEntity.ok(cartService.clearCart());
    }
}
