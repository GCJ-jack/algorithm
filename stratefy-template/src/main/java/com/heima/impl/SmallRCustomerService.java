package com.heima.impl;

import com.heima.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class SmallRCustomerService implements CustomerService {

    @Override
    public String findCustomer() {
        System.out.println("小R玩家客服");
        return "小R玩家客服";
    }
}
