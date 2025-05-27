package com.example.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemRequestDTO {
    @NotBlank(message = "Name is required and cannot be empty")
    @Size(max = 255, message = "Name must not exceed 255 characters")
    private String name;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0.00")
    @Digits(integer = 10, fraction = 2, message = "Price must be a valid monetary amount with up to 2 decimal places")
    private BigDecimal price;
    
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;
}
