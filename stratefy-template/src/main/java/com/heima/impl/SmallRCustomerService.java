package com.heima.impl;

import com.heima.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)

public class SmallRCustomerService implements CustomerService {

    @Override
    public boolean support(int recharge) {
        return recharge > 100 && recharge <= 200;
    }

    @Override
    public String findCustomer() {
        System.out.println("小R玩家客服");
        return "小R玩家客服";
    }
}
