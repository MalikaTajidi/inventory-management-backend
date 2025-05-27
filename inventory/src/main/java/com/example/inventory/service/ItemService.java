package com.example.inventory.service;

import java.util.List;

import com.example.inventory.dto.ItemRequestDTO;
import com.example.inventory.dto.ItemResponseDTO;

public interface ItemService {
    List<ItemResponseDTO> getAllItems();
    ItemResponseDTO createItem(ItemRequestDTO itemDTO);
    void deleteItem(Long id);
}
