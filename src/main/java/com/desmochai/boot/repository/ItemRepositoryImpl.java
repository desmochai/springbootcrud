package com.desmochai.boot.repository;

import com.desmochai.boot.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private final DynamoDbClient dynamoDbClient;
    private static final String TABLE_NAME = "items";

    @Override
    public void save(Item item) {
        Map<String, AttributeValue> itemMap = new HashMap<>();
        itemMap.put("id", AttributeValue.builder().s(item.getId()).build());
        itemMap.put("name", AttributeValue.builder().s(item.getName()).build());
        itemMap.put("description", AttributeValue.builder().s(item.getDescription()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(TABLE_NAME)
                .item(itemMap)
                .build();

        dynamoDbClient.putItem(request);
    }

    @Override
    public List<Item> getAllItems() {
        ScanRequest request = ScanRequest.builder()
                .tableName(TABLE_NAME)
                .build();

        ScanResponse response = dynamoDbClient.scan(request);

        List<Item> items = new ArrayList<>();

        for (Map<String, AttributeValue> map : response.items()) {
            Item item = new Item();
            item.setId(map.get("id").s());
            item.setName(map.get("name").s());
            item.setDescription(map.get("description").s());
            items.add(item);
        }

        return items;
    }

    @Override
    public Item getItemById(String id) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("id", AttributeValue.builder().s(id).build());

        GetItemRequest request = GetItemRequest.builder()
                .tableName(TABLE_NAME)
                .key(key)
                .build();

        GetItemResponse response = dynamoDbClient.getItem(request);
        Map<String, AttributeValue> returnedItem = response.item();

        if (returnedItem == null || returnedItem.isEmpty()) {
            System.out.println("No item found with id: " + id);
            return null;
        }

        // debugging
        System.out.println("Returned Item: " + returnedItem);

        Item item = new Item();
        item.setId(returnedItem.getOrDefault("id", AttributeValue.fromS("")).s());
        item.setName(returnedItem.getOrDefault("name", AttributeValue.fromS("")).s());
        item.setDescription(returnedItem.getOrDefault("description", AttributeValue.fromS("")).s());
        return item;
    }
}
