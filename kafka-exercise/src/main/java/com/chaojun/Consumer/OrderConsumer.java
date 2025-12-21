package com.chaojun.Consumer;

import com.chaojun.DTO.Order;
import com.chaojun.Service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderConsumer {

    private final ObjectMapper objectMapper;
    private final OrderService orderService;

    public OrderConsumer(ObjectMapper objectMapper, OrderService orderService) {
        this.objectMapper = objectMapper;
        this.orderService = orderService;
    }


    @KafkaListener(topics = "${app.kafka.topic}", groupId = "demo-consumer-group")
    public void listen(String message) throws Exception {
        log.info("收到 Kafka 消息: {}", message);

        Order order = objectMapper.readValue(message, Order.class);
        orderService.save(order);

        log.info("落库成功: orderId={}", order.getOrderId());
    }
}
