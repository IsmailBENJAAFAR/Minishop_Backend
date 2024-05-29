package com.example.minishop_backend;

import static org.junit.jupiter.api.Assertions.*;

import com.example.minishop_backend.cart.CartService;
import com.example.minishop_backend.produit.ProduitService;
import com.example.minishop_backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@DisplayName("Spring Boot Application Test")
@RequiredArgsConstructor
class MinishopBackendApplicationTests {
    private final CartService cartService;

    @Test
    @DisplayName("╯°□°）╯")
    void cartTest() {
        cartService.addItemsToCart(1L, 3);
        cartService.addItemsToCart(2L, 5);
        var items = cartService.getItemsInCart();

        assertEquals(items.size(), 2);
        assertEquals(items.get(0).getQuantity(), 3);
        assertEquals(items.get(0).getProduit().getId(), 1L);
        assertEquals(items.get(1).getQuantity(), 5);
        assertEquals(items.get(1).getProduit().getId(), 2L);

        cartService.removeItemsFromCart(1L);
        items = cartService.getItemsInCart();

        assertEquals(items.get(0).getQuantity(), 5);
        assertEquals(items.get(0).getProduit().getId(), 2L);

        cartService.clearCart();
        items = cartService.getItemsInCart();

        assertEquals(items.size(), 0);
    }

    @Test
    void contextLoads() {
    }

}
