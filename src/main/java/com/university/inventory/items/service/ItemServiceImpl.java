package com.university.inventory.items.service;

import com.university.inventory.items.controller.ShoppingItem;
import com.university.inventory.items.repository.ShoppingItemRepository;
import com.university.inventory.items.service.mapper.ShoppingItemMapper;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    private ShoppingItemRepository shoppingItemRepository;

    public ItemServiceImpl(ShoppingItemRepository shoppingItemRepository) {
        this.shoppingItemRepository = shoppingItemRepository;
    }

    @Override
    public List<ShoppingItem> getAvailableItems() {
        var dtoList = ShoppingItemMapper.toDtoList(shoppingItemRepository.getAll());
        return dtoList;
    }
}
