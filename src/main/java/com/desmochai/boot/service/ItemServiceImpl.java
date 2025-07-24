package com.desmochai.boot.service;

import com.desmochai.boot.model.Item;
import com.desmochai.boot.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}