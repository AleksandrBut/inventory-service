package com.microservices.inventory.service.impl;

import com.microservices.inventory.model.Inventory;
import com.microservices.inventory.model.dto.InventoryDto;
import com.microservices.inventory.model.mapper.InventoryMapper;
import com.microservices.inventory.repository.InventoryRepository;
import com.microservices.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {
        return inventoryMapper.toDto(
                inventoryRepository.save(
                        inventoryMapper.toModel(inventoryDto)
                )
        );
    }

    @Override
    public InventoryDto updateInventory(InventoryDto inventoryDto) {
        return inventoryMapper.toDto(
                inventoryRepository.save(
                        inventoryMapper.toModel(inventoryDto)
                )
        );
    }

    @Override
    public InventoryDto getInventory(Long id) {
        return inventoryMapper.toDto(
                inventoryRepository.findById(id)
                        .orElse(null)
        );
    }

    @Override
    public List<InventoryDto> getInventories() {
        return inventoryMapper.toDtoList((List<Inventory>) inventoryRepository.findAll());
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
