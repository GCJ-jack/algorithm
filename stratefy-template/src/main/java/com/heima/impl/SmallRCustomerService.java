package com.heima.impl;

import com.heima.enums.UserType;
import com.heima.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)

public class SmallRCustomerService implements CustomerService {

    @Override
    public UserType support() {
        return UserType.SMALL;
    }

    @Override
    public String findCustomer() {
        System.out.println("小R玩家客服");
        return "小R玩家客服";
    }
}
