package com.example.minishop_backend.cart;

import com.example.minishop_backend.items.Items;
import com.example.minishop_backend.produit.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping()
    public ResponseEntity<List<Items>> getCart() {
        return ResponseEntity.ok(cartService.getItemsInCart());
    }

    @PostMapping("add")
    public ResponseEntity<List<Items>> addToCart(@RequestBody() CartDTO dto) {
        return ResponseEntity.ok(cartService.addItemsToCart(dto.getProductId(), dto.getQuantity()));
    }

    @PostMapping("clear")
    public ResponseEntity<List<Items>> clearCart() {
        return ResponseEntity.ok(cartService.clearCart());
    }

    @PostMapping("remove/{productId}")
    public ResponseEntity<List<Items>> removeFromCart(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(cartService.removeItemsFromCart(productId));
    }
}
