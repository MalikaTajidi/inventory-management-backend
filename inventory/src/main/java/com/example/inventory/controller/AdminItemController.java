package com.example.inventory.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.dto.ItemRequestDTO;
import com.example.inventory.dto.ItemResponseDTO;
import com.example.inventory.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/items")
public class AdminItemController {
    
    private ItemService itemService;

    public AdminItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemResponseDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping
    public ResponseEntity<ItemResponseDTO> createItem(@Valid @RequestBody ItemRequestDTO dto) {
           ItemResponseDTO createdItem = itemService.createItem(dto);
        return ResponseEntity
            .status(HttpStatus.CREATED) 
            .body(createdItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

}
