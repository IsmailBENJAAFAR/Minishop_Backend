package com.example.minishop_backend.cart;

import lombok.Data;

@Data
public class CartDTO {
    private Long productId;
    private int quantity;
}
