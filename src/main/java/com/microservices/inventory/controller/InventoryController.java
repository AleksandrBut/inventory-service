package com.microservices.inventory.controller;

import com.microservices.inventory.model.dto.InventoryDto;
import com.microservices.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryDto> createInventory(@RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.status(CREATED)
                .body(inventoryService.createInventory(inventoryDto));
    }

    @PutMapping
    public ResponseEntity<InventoryDto> updateInventory(@RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.updateInventory(inventoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getInventory(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryService.getInventory(id));
    }

    @GetMapping
    public ResponseEntity<List<InventoryDto>> getInventories() {
        return ResponseEntity.ok(inventoryService.getInventories());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.ok()
                .build();
    }

    @GetMapping("/stock")
    public ResponseEntity<Boolean> isInStock(@RequestParam String skuCode,
                                             @RequestParam Integer quantity) {
        return ResponseEntity.ok(inventoryService.isInStock(skuCode, quantity));
    }
}
