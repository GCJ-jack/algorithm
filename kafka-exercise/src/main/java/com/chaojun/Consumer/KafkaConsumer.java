package com.chaojun.Consumer;

import com.alibaba.fastjson2.JSON;
import com.chaojun.DTO.Order;
import com.chaojun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "order-topic", groupId = "demo-consumer-group")
    public void listen(String message) {
        // 1. 反序列化（如果是 JSON）
        Order order = JSON.parseObject(message, Order.class);

        // 2. 落库
        orderService.save(order);
    }
}
