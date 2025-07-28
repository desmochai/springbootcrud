package com.desmochai.boot.service;

import com.desmochai.boot.model.Item;
import com.desmochai.boot.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceImplTest {

    private ItemRepository itemRepository;
    private ItemServiceImpl itemService;

    @BeforeEach
    void setUp() {
        itemRepository = mock(ItemRepository.class);
        itemService = new ItemServiceImpl(itemRepository);
    }

    @Test
    void testSaveItem() {
        Item item = new Item("1", "Test", "Demo");
        itemService.saveItem(item);
        verify(itemRepository, times(1)).save(item);
    }

    @Test
    void testGetItemById() {
        Item item = new Item("1", "Test", "Demo");
        when(itemRepository.getItemById("1")).thenReturn(item);

        Item result = itemService.getItemById("1");

        assertNotNull(result);
        assertEquals("Test", result.getName());
        assertEquals("Demo", result.getDescription());
    }

    @Test
    void testGetAllItems() {
        List<Item> mockList = List.of(new Item("1", "Test1", "Desc1"), new Item("2", "Test2", "Desc2"));
        when(itemRepository.getAllItems()).thenReturn(mockList);

        List<Item> result = itemService.getAllItems();

        assertEquals(2, result.size());
        assertEquals("Test1", result.get(0).getName());
    }

    @Test
    void testUpdateItem() {
        Item item = new Item("1", "Updated", "Updated desc");
        itemService.updateItem("1", item);
        verify(itemRepository).updateItem("1", item);
    }

    @Test
    void testDeleteItem() {
        itemService.deleteItem("1");
        verify(itemRepository).deleteItem("1");
    }
}