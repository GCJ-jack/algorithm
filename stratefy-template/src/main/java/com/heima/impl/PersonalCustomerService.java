package com.heima.impl;

import com.heima.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)

public class PersonalCustomerService implements CustomerService {

    @Override
    public boolean support(int recharge) {
        return recharge > 50 && recharge <= 100;
    }

    @Override
    public String findCustomer() {
        return "专属客服";
    }


}
