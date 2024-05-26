package com.example.minishop_backend.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Long> productIds = new ArrayList<>();

    public List<Long> getProductIds() {
        return productIds;
    }
}
