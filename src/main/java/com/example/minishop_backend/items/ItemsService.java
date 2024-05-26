package com.example.minishop_backend.items;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemsService {
    private final ItemsRepository itemsRepository;

    public List<Items> getItems() {
        return itemsRepository.findAll();
    }

    public Items addItems(Items items) {
        return itemsRepository.save(items);
    }

    @Transactional
    public void updateItems(Long id, int quantity) {
        Items oldItem = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with id " + id + " does not exists"));
        ;
        if (quantity > 0 &&
                oldItem.getQuantity() != quantity) {
            oldItem.setQuantity(quantity);
        }
    }

    public void deleteItems(Long id) {
        boolean exists = itemsRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Item with id " + id + " does not exists");
        }
        itemsRepository.deleteById(id);
    }

    public List<Items> searchItems() {
        return null;
    }
}
