package com.desmochai.boot.repository;

import com.desmochai.boot.model.Item;

import java.util.List;

public interface ItemRepository {
    void save(Item item);
    Item getItemById(String id);
    List<Item> getAllItems();
}