package com.heima.impl;

import com.heima.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class DefaultCustomerService implements CustomerService {


    @Override
    public String findCustomer() {
        return "找不到客服";
    }
}