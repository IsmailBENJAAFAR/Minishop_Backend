package com.example.minishop_backend.commande;

import com.example.minishop_backend.cart.CartService;
import com.example.minishop_backend.items.Items;
import com.example.minishop_backend.items.ItemsService;
import com.example.minishop_backend.produit.ProduitService;
import com.example.minishop_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final ProduitService produitService;
    private final ItemsService itemsService;
    private final UserService userService;
    private final CartService cartService;

    public List<Commande> getCommandes() {
        return commandeRepository.findAll();
    }

    public List<Commande> getUserCommandes() {
        Long userId = userService.getCurrentUser().getId();
        return commandeRepository.findAll().stream()
                .filter(commande -> commande.getUser().getId().equals(userId)).toList();
    }

    public void addCommande(Commande commande) {
        commandeRepository.save(commande);
    }

    public Commande addCommandeFromCart() {
        List<Items> items = cartService.getItemsInCart();

        items.forEach(items1 -> {
            if (items1.getProduit().getQuantity() < items1.getQuantity())
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough items available to fulfill this command");
        });

        items.forEach(items1 -> {
            var produit = items1.getProduit();
            produitService.updateProduit(
                    produit.getId(),
                    null,
                    null,
                    -1,
                    null,
                    null,
                    produit.getQuantity() - items1.getQuantity()
            );
        });

        Commande commande = new Commande();
        commande.setDate(new Date());
        commande.setUser(userService.getCurrentUser());

        commande = commandeRepository.save(commande);
        Commande finalCommande = commande;
        items.forEach(items1 -> items1.setCommande(finalCommande));
        items.forEach(itemsService::addItems);
        cartService.clearCart();

        return commande;
    }

    @Transactional
    public void updateCommande(Long id, Date date) {
        Commande oldCommande = commandeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Commande with id " + id + " does not exists"));
        ;
        if (date != null &&
                !Objects.equals(oldCommande.getDate(), date)) {
            oldCommande.setDate(date);
        }
    }

    public void deleteCommande(Long id) {
        boolean exists = commandeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Commande with id " + id + " does not exists");
        }
        commandeRepository.deleteById(id);
    }
}
