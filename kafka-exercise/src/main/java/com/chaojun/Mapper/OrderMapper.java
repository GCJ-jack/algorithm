package com.chaojun.Mapper;

import com.chaojun.DTO.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void insert(Order order);
}
