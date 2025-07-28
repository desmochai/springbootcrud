package com.desmochai.boot.controller;

import com.desmochai.boot.model.Item;
import com.desmochai.boot.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*
* 	•	@RestController: Tells Spring this is a REST endpoint provider
	•	@RequestMapping("/items"): All routes in here will be prefixed with /items
	•	@PostMapping: Maps POST /items
	•	@RequestBody: Spring will parse JSON payload into an Item object
	•	We return a 201 Created with a success message
*
* */

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody Item item) {
        itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable String id, @RequestBody Item item) {
        try {
            itemService.updateItem(id, item);
            return ResponseEntity.ok("Item updated successfully");
        } catch (Exception e) {
            e.printStackTrace(); // TODO: replace with robust logging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update item: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id) {
        try {
            itemService.deleteItem(id);
            return ResponseEntity.ok("Item deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete item.");
        }
    }
}