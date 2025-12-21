package com.chaojun.Controller;


import com.chaojun.DTO.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProducerController {


    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final String topic;


    public OrderProducerController(
            KafkaTemplate<String, String> kafkaTemplate,
            ObjectMapper objectMapper,
            org.springframework.core.env.Environment env
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.topic = env.getProperty("app.kafka.topic", "order-topic");
    }


    @PostMapping("/produce")
    public String produce(@RequestBody Order order) throws Exception{
        String json = objectMapper.writeValueAsString(order);
        kafkaTemplate.send(topic,order.getOrderId(),json);
        return "send: " + json;
    }
    
}
