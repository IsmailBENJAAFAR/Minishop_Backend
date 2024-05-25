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
            @PathVariable("productID") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) float price,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) int quantity
    ){
        Produit produit = new Produit(id,name,category,price,brand,description,quantity);
        produitService.updateProduit(produit);
    }
}
