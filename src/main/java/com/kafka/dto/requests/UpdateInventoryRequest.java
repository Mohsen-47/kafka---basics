package com.kafka.dto.requests;


public record UpdateInventoryRequest(Long itemId , Integer stockQuantity) {
    @Override
    public Long itemId() {
        return itemId;
    }

    public UpdateInventoryRequest(Long itemId, Integer stockQuantity) {
        this.itemId = itemId;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public Integer stockQuantity() {
        return stockQuantity;
    }
}
