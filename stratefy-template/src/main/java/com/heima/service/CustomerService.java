package com.heima.service;

import com.heima.enums.UserType;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    UserType support();

    String findCustomer();
}
