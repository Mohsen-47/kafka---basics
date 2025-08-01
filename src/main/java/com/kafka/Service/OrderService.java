package com.kafka.Service;

import com.kafka.dto.requests.BuyOrderRequest;

public interface OrderService {
    void buyOrder(BuyOrderRequest request);
}
