package com.example.minishop_backend.notation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotationService {
    private final NotationRepository notationRepository;
    public List<Notation> getNotations(){
        return notationRepository.findAll();
    }
    public void addNotation(Notation notation){
        notationRepository.save(notation);
    }
    @Transactional
    public void updateNotation(Long id,int etoiles){
        Notation oldNotation = notationRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Notation with id " + id + " does not exists"));;
        if (etoiles>0 &&
                oldNotation.getEtoiles() != etoiles){
            oldNotation.setEtoiles(etoiles);
        }
    }
    public void deleteNotation(Long id){
        boolean exists = notationRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Notation with id " + id + " does not exists");
        }
        notationRepository.deleteById(id);
    }
}
