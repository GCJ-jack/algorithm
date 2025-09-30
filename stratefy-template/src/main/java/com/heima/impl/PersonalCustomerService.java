package com.heima.impl;

import com.heima.annotations.SupportUserType;
import com.heima.enums.UserType;
import com.heima.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@SupportUserType(UserType.PERSONAL)
public class PersonalCustomerService implements CustomerService {

    @Override
    public UserType support() {
        return UserType.PERSONAL;
    }

    @Override
    public String findCustomer() {
        return "专属客服";
    }


}
