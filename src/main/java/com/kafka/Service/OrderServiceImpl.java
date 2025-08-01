package com.kafka.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.requests.BuyOrderRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void buyOrder(BuyOrderRequest request) {
        String itemInJsonFormat = buildJsonMetaData(request);
        kafkaTemplate.send(request.topic(),"order", itemInJsonFormat);
    }

    private String buildJsonMetaData(BuyOrderRequest request) {
        Map<String, Object> item = new HashMap<>();
        item.put("itemId", request.item().itemId());
        item.put("stockQuantity", request.item().stockQuantity());
        Map<String, Object> wrapper = new HashMap<>();
        wrapper.put("item", item);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(wrapper);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
