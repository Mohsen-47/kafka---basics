package com.kafka.Service;


import com.kafka.dto.Item;
import com.kafka.dto.requests.UpdateInventoryRequest;

import java.util.List;


public interface InventoryService {
    void updateInventory(UpdateInventoryRequest request);

    List<Item> getAllItems();
}
