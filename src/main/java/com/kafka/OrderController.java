package com.kafka;

import com.kafka.Service.OrderService;
import com.kafka.dto.requests.BuyOrderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/send-buy-order")
    public void sentOrder(@RequestBody(required = true) BuyOrderRequest request) {
        orderService.buyOrder(request);
    }

}
