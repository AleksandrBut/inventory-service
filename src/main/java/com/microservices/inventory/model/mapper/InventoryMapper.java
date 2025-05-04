package com.microservices.inventory.model.mapper;

import com.microservices.inventory.model.Inventory;
import com.microservices.inventory.model.dto.InventoryDto;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface InventoryMapper {

    InventoryDto toDto(Inventory inventory);

    Inventory toModel(InventoryDto inventoryDto);

    List<InventoryDto> toDtoList(List<Inventory> inventories);
}
