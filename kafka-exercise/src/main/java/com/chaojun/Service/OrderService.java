package com.chaojun.Service;

import com.chaojun.DTO.Order;
import com.chaojun.Mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderService {
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Transactional
    public void save(Order order) {
        // 最简单：直接 insert（order_id 唯一键会帮你挡重复）
        orderMapper.insert(order);
    }
}