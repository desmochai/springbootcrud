package com.desmochai.boot.repository;

import com.desmochai.boot.model.Item;

public interface ItemRepository {
    void save(Item item);
    Item getItemById(String id);
}