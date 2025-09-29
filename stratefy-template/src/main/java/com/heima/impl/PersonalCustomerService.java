package com.heima.impl;

import com.heima.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class PersonalCustomerService implements CustomerService {

    @Override
    public String findCustomer() {
        return "专属客服";
    }


}
