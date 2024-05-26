package com.example.minishop_backend.commande;

import com.example.minishop_backend.cart.CartService;
import com.example.minishop_backend.items.Items;
import com.example.minishop_backend.items.ItemsService;
import com.example.minishop_backend.notation.Notation;
import com.example.minishop_backend.produit.Produit;
import com.example.minishop_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommandeService {
    private final CommandeRepository commandeRepository;
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

//        items = itemsService.addMultipleItems(items);

        Commande commande = new Commande();
        commande.setDate(new Date());
        commande.setItems(items);
        commande.setUser(userService.getCurrentUser());

        commande = commandeRepository.save(commande);
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
