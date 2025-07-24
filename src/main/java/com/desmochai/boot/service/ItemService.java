package com.desmochai.boot.service;

import com.desmochai.boot.model.Item;

public interface ItemService {
    void saveItem(Item item);
    Item getItemById(String id);
}