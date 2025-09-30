package com.heima.impl;

import com.heima.enums.UserType;
import com.heima.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class NormalCustomerService implements CustomerService {

    @Override
    public UserType support() {
        return UserType.NORMAL;
    }

    @Override
    public String findCustomer() {
        return "该用户是普通用户";
    }

}
