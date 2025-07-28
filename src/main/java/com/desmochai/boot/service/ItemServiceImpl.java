package com.desmochai.boot.service;

import com.desmochai.boot.model.Item;
import com.desmochai.boot.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item getItemById(String id) {
        return itemRepository.getItemById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    @Override
    public void updateItem(String id, Item item) {
        itemRepository.updateItem(id, item);
    }

}