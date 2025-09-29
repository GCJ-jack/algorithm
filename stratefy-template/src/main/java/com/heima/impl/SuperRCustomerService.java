package com.heima.impl;

import com.heima.service.CustomerService;

public class SuperRCustomerService implements CustomerService {

    @Override
    public String findCustomer() {
        System.out.println("超R玩家客服");
        return "超R玩家客服";
    }
}
