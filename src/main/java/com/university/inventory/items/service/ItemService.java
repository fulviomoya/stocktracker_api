package com.university.inventory.items.service;

import com.university.inventory.items.controller.ShoppingItem;

import java.util.List;

public interface ItemService {

    List<ShoppingItem> getAvailableItems();
}
