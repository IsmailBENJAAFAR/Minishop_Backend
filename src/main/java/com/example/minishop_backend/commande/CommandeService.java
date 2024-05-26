package com.example.minishop_backend.commande;

import com.example.minishop_backend.notation.Notation;
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
    public List<Commande> getCommandes(){
        return commandeRepository.findAll();
    }
    public void addCommande(Commande commande){
        commandeRepository.save(commande);
    }
    @Transactional
    public void updateCommande(Long id, Date date){
        Commande oldCommande = commandeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Commande with id " + id + " does not exists"));;
        if (date!=null &&
                !Objects.equals(oldCommande.getDate(),date)){
            oldCommande.setDate(date);
        }
    }
    public void deleteCommande(Long id){
        boolean exists = commandeRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Commande with id " + id + " does not exists");
        }
        commandeRepository.deleteById(id);
    }
}
