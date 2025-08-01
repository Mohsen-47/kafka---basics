package com.kafka.Service;

import com.kafka.dto.Item;
import com.kafka.dto.ItemRepository;
import com.kafka.dto.requests.UpdateInventoryRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    ItemRepository itemRepository;

    @Override
    @Transactional
    public void updateInventory(UpdateInventoryRequest request) {
        Item item = itemRepository.getReferenceById(request.itemId());
        item.setStockQuantity(item.getStockQuantity() - request.stockQuantity());
        itemRepository.save(item);
    }
}
