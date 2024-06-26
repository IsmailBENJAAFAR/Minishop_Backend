package com.example.minishop_backend.commande;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("commande")
@RequiredArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    @GetMapping("adminOnly/all")
    public List<Commande> getAllCommandes() {
        return commandeService.getCommandes();
    }

    @GetMapping("all")
    public List<Commande> getAllUserCommandes() {
        return commandeService.getUserCommandes();
    }

    @PostMapping("addFromCart")
    public ResponseEntity<Commande> addCommandeFromCart() {
        return ResponseEntity.ok(commandeService.addCommandeFromCart());
    }
}
