package com.example.inventory.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemResponseDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
}
