package com.kafka.dto.requests;

import lombok.Builder;

@Builder
public record ItemDto(Long itemId, Integer stockQuantity) {
}
