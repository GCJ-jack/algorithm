package com.heima.controller;


import com.heima.impl.*;
import com.heima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    List<CustomerService> customerServiceList;
    @GetMapping("/customer/{recharge}")
    public String customer(@PathVariable(value = "recharge") int recharge){
        //分为普通用户 定制用户 尊享用户 至尊用户

        if(recharge >= 0 && recharge <= 50){
            return new NormalCustomerService().findCustomer();
        }

        if(recharge > 50 && recharge <= 100){
            return new PersonalCustomerService().findCustomer();
        }

        if(recharge > 100 && recharge <= 200){
            return new SmallRCustomerService().findCustomer();
        }

        if(recharge > 200){
            return new SuperRCustomerService().findCustomer();
        }

        return new DefaultCustomerService().findCustomer();
    }
}
