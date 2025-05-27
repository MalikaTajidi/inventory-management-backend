package com.example.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
