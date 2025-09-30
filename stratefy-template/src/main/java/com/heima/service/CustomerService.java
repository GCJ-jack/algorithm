package com.heima.service;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    boolean support(int recharge);

    String findCustomer();
}
