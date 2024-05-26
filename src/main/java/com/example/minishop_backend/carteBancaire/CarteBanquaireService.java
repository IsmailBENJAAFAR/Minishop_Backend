package com.example.minishop_backend.carteBancaire;

import com.example.minishop_backend.produit.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CarteBanquaireService {
    private final CarteBanquaireRepository carteBanquaireRepository;
    public List<CarteBanquaire> getCartes(){
        return carteBanquaireRepository.findAll();
    }
    public void addCarte(CarteBanquaire carte){
        carteBanquaireRepository.save(carte);
    }
    @Transactional
    public void updateCarte(Long id,
                            String type,
                            String rib){
        CarteBanquaire oldCartBancaire = carteBanquaireRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Cart Bancaire with id " + id + " does not exists"));
        if (type != null &&
                !type.isEmpty() &&
                !Objects.equals(oldCartBancaire.getType(), type)) {
            oldCartBancaire.setType(type);
        }
        if (rib != null &&
                !rib.isEmpty() &&
                !Objects.equals(oldCartBancaire.getRib(), rib)) {
            oldCartBancaire.setRib(rib);
        }
    }
    public void deleteCarte(Long id){
        boolean exists = carteBanquaireRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Cart Bancaire with id " + id + " does not exists");
        }
        carteBanquaireRepository.deleteById(id);
    }
}
