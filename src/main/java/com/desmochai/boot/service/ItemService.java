package com.desmochai.boot.service;

import com.desmochai.boot.model.Item;

import java.util.List;

public interface ItemService {
    void saveItem(Item item);
    Item getItemById(String id);
    List<Item> getAllItems();
}