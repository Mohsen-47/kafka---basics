package com.kafka.dto.requests;

import lombok.Builder;

@Builder
public record UpdateInventoryRequest(Long itemId , Integer stockQuantity) {
}
