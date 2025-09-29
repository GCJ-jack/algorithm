package com.heima.impl;

import com.heima.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class NormalCustomerService implements CustomerService {

    @Override
    public String findCustomer() {
        return "该用户是普通用户";
    }

}
