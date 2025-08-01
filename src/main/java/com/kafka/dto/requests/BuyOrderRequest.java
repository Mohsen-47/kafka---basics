package com.kafka.dto.requests;

import lombok.Builder;

@Builder
public record BuyOrderRequest(ItemDto item , String topic ) {
}
