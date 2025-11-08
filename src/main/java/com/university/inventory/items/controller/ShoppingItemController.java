package com.university.inventory.items.controller;

import com.university.inventory.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/item")
public class ShoppingItemController {

    @Autowired
    ItemService service;

    @GetMapping
    public ResponseEntity<List<ShoppingItem>> getAvailableItem() {
        var items = service.getAvailableItems();
        return ResponseEntity.ok(items);
    }
}
