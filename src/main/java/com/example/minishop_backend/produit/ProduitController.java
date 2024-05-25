package com.example.minishop_backend.produit;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produit")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @GetMapping("products")
    public List<Produit> findProducts() {
        return produitService.getProduits();
    }

    @PostMapping("adminOnly/new")
    public void registerNewProduct(@RequestBody Produit produit){
        produitService.addProduit(produit);
    }
    @DeleteMapping("adminOnly/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") Long id){
        produitService.deleteProduit(id);
    }
    @PutMapping("adminOnly/update/{productId}")
    public void updateProduct(
            @PathVariable("productId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Float price,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer quantity
    ){
        if (price == null){
            price = (float) 0;
        }
        if (quantity == null){
            quantity = -1;
        }
        produitService.updateProduit(id,name,category,price,brand,description,quantity);
    }
}
