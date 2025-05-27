package com.example.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.dto.ItemResponseDTO;
import com.example.inventory.service.ItemService;

@RestController
@RequestMapping("/items")
public class CustomerItemController {
    
    private ItemService itemService;

    public CustomerItemController(ItemService itemService){
        this.itemService = itemService;

    }

    @GetMapping
    public List<ItemResponseDTO> getItems() {
        return itemService.getAllItems();
    }
}
