package com.example.minishop_backend.produit;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("produit")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @GetMapping("all")
    public List<Produit> findProducts() {
        return produitService.getProduits();
    }

    @PostMapping("adminOnly/new")
    public void registerNewProduct(@RequestBody Produit produit) {
        produitService.addProduit(produit);
    }

    @DeleteMapping("adminOnly/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") Long id) {
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
    ) {
        if (price == null) {
            price = (float) 0;
        }
        if (quantity == null) {
            quantity = -1;
        }
        produitService.updateProduit(id, name, category, price, brand, description, quantity);
    }

    @GetMapping("search")
    public List<Produit> searchProduit(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String brand,
                                       @RequestParam(required = false) String category,
                                       @RequestParam(required = false) Float lowerPrice,
                                       @RequestParam(required = false) Float higherPrice) {
        if (lowerPrice == null) {
            lowerPrice = (float) 0;
        }
        if (higherPrice == null) {
            higherPrice = 99999999F;
        }
        return produitService.searchProduit(name, brand, category, lowerPrice, higherPrice);
    }

    @GetMapping("{productId}")
    public ResponseEntity<Produit> getProduitById(@PathVariable("productId") Long id) {
        return ResponseEntity.ok(produitService.getProduit(id));
    }
}
