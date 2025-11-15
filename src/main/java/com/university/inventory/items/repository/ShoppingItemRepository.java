package com.university.inventory.items.repository;

import com.university.inventory.items.repository.model.ShoppingItemEntity;
import org.hibernate.annotations.processing.Find;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepository {

    @Find
    List<ShoppingItemEntity> getAll();

}
