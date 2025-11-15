package com.university.inventory.items.service.mapper;

import com.university.inventory.items.controller.ShoppingItem;
import com.university.inventory.items.repository.model.ShoppingItemEntity;

import java.util.List;

public class ShoppingItemMapper {
    public static List<ShoppingItem> toDtoList(List<ShoppingItemEntity> entity) {
        var objectConverted = entity.stream().map(ShoppingItemMapper::toDto).toList();
        return objectConverted;
    }

    public static ShoppingItem toDto(ShoppingItemEntity entity) {
        return new ShoppingItem(entity.getName(), entity.getPrice());
    }
}
