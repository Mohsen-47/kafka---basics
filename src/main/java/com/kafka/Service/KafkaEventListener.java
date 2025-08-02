package com.kafka.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.Item;
import com.kafka.dto.requests.ItemDto;
import com.kafka.dto.requests.UpdateInventoryRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KafkaEventListener {

    private final InventoryService inventoryService;

    public KafkaEventListener(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics = "buyOrder" ,groupId = "order")
    @Transactional
    public void listener(String data) {
        System.out.println("event processed - topic : buyOrder" );
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = mapper.readTree(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonNode itemNode = rootNode.path("item");
        long itemId = itemNode.path("itemId").asLong();
        int stockQuantity = itemNode.path("stockQuantity").asInt();
        UpdateInventoryRequest request = new UpdateInventoryRequest(itemId, stockQuantity);
        inventoryService.updateInventory(request);
        List<Item> allItems = inventoryService.getAllItems();
        allItems.forEach(item -> {
            System.out.println("item = " + item.getStockQuantity().toString());
        });
        System.out.println("finish");
    }
}
