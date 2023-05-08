package com.hiberus.university.cecilia.maven.first.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

public class InventoryItem {
    private String name;
    private String description;
    private String price;
}
