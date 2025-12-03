package com.university.inventory.items.service;

import com.university.inventory.items.controller.ShoppingItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<ShoppingItem> getAvailableItems();
}
