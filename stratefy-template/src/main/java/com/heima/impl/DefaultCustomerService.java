package com.heima.impl;

import com.heima.enums.UserType;
import com.heima.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class DefaultCustomerService implements CustomerService {


    @Override
    public UserType support() {
        return null;
    }

    @Override
    public String findCustomer() {
        return "找不到客服";
    }
}