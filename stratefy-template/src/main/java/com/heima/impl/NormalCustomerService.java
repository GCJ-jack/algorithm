package com.heima.impl;

import com.heima.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class NormalCustomerService implements CustomerService {

    @Override
    public boolean support(int recharge) {
        return recharge >= 0 && recharge <= 50;
    }

    @Override
    public String findCustomer() {
        return "该用户是普通用户";
    }

}
