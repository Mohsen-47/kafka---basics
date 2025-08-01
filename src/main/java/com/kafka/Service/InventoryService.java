package com.kafka.Service;


import com.kafka.dto.requests.UpdateInventoryRequest;


public interface InventoryService {
    void updateInventory(UpdateInventoryRequest request);
}
