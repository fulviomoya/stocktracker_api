package com.university.inventory.items.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "shopping_item")
public class ShoppingItemEntity {
    @Id
    @GeneratedValue
    private long _id;
    private String name;
    private float price;

    public ShoppingItemEntity() {

    }

    public ShoppingItemEntity(long _id, String name, float price) {
        this._id = _id;
        this.name = name;
        this.price = price;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingItemEntity that = (ShoppingItemEntity) o;
        return _id == that._id && Float.compare(price, that.price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, price);
    }
}
