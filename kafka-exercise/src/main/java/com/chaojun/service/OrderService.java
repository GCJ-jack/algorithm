package com.chaojun.service;

import com.chaojun.DTO.Order;
import com.chaojun.Mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public void save(Order order) {
        orderMapper.insert(order);
    }
}