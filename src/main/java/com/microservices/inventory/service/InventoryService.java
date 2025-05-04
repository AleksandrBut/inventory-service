package com.microservices.inventory.service;

import com.microservices.inventory.model.dto.InventoryDto;

import java.util.List;

public interface InventoryService {

    InventoryDto createInventory(InventoryDto inventoryDto);

    InventoryDto updateInventory(InventoryDto inventoryDto);

    InventoryDto getInventory(Long id);

    List<InventoryDto> getInventories();

    void deleteInventory(Long id);
}
