package com.kafka.Service;

import com.kafka.dto.Item;
import com.kafka.dto.ItemRepository;
import com.kafka.dto.requests.UpdateInventoryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final ItemRepository itemRepository;

    public InventoryServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public void updateInventory(UpdateInventoryRequest request) {
        Item item = itemRepository.getReferenceById(request.itemId());
        item.setStockQuantity(item.getStockQuantity() - request.stockQuantity());
        itemRepository.saveAndFlush(item);


    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

}
