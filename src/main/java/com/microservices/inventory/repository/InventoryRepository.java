package com.microservices.inventory.repository;

import com.microservices.inventory.model.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
