package com.heima.impl;

import com.heima.annotations.SupportUserType;
import com.heima.enums.UserType;
import com.heima.service.CustomerService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@SupportUserType(UserType.SMALL)

public class SmallRCustomerService implements CustomerService {

    @Override
    public UserType support() {
        return UserType.SMALL;
    }

    @Override
    public String findCustomer() {
        System.out.println("小R玩家客服");
        return "小R玩家客服";
    }
}
