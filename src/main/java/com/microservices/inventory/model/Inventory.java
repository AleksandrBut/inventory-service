package com.microservices.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@Entity
@Table
public class Inventory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
