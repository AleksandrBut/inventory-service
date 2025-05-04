package com.microservices.inventory.model.dto;

public record InventoryDto(
        Long id,
        String skuCode,
        Integer quantity
) {
}
