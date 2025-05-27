package com.example.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.inventory.dto.ItemRequestDTO;
import com.example.inventory.dto.ItemResponseDTO;
import com.example.inventory.entity.Item;
import com.example.inventory.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
    
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
       this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(item -> {
                    ItemResponseDTO dto = new ItemResponseDTO();
                    dto.setId(item.getId());
                    dto.setName(item.getName());
                    dto.setPrice(item.getPrice());
                    dto.setDescription(item.getDescription());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemResponseDTO createItem(ItemRequestDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setDescription(itemDTO.getDescription());
        
        Item savedItem = itemRepository.save(item);
        
        ItemResponseDTO responseDTO = new ItemResponseDTO();
        responseDTO.setId(savedItem.getId());
        responseDTO.setName(savedItem.getName());
        responseDTO.setPrice(savedItem.getPrice());
        responseDTO.setDescription(savedItem.getDescription());
        return responseDTO;
    }

    @Override
    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item not found with id: " + id);
        }
        itemRepository.deleteById(id);
    }
}
