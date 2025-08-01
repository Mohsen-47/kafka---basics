package com.kafka.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.requests.ItemDto;
import com.kafka.dto.requests.UpdateInventoryRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventListener {

    private final InventoryService inventoryService;

    public KafkaEventListener(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics = "buyOrder" ,groupId = "order")
    public void listener(String data) {
        System.out.println("event processed - topic : buyOrder" );
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readTree(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonNode itemNode = rootNode.path("item");
        long itemId = itemNode.path("itemId").asLong();
        int stockQuantity = itemNode.path("stockQuantity").asInt();
        UpdateInventoryRequest request  = UpdateInventoryRequest.builder()
                .itemId(itemId)
                .stockQuantity(stockQuantity)
                .build();
        inventoryService.updateInventory(request);
    }
}
