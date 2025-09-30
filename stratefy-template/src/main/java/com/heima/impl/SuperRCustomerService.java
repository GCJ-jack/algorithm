package com.heima.impl;

import com.heima.enums.UserType;
import com.heima.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)

public class SuperRCustomerService implements CustomerService {

    @Override
    public UserType support() {
        return UserType.BIG;
    }

    @Override
    public String findCustomer() {
        System.out.println("超R玩家客服");
        return "超R玩家客服";
    }
}
