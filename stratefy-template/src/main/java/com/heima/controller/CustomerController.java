package com.heima.controller;


import com.heima.enums.UserType;
import com.heima.impl.*;
import com.heima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@RestController
public class CustomerController {

    Map<UserType,CustomerService> serviceMap;

    @Autowired
    DefaultCustomerService defaultCustomerService;

    @GetMapping("/customer/{recharge}")
    public String customer(@PathVariable(value = "recharge") int recharge){
        //分为普通用户 定制用户 尊享用户 至尊用户

        for(CustomerService customerService:customerServiceList){
            if(customerService.support(recharge)){
                return customerService.findCustomer();
            }
        }
        return "can't find any customer";
    }

    @Autowired
    public void setCustomerServiceMap(List<CustomerService> list){
        serviceMap = list.stream()
                .filter(customerService -> customerService.support()!=null)
                .collect(Collectors.toMap(CustomerService::support, Function.identity()));

    }


}
