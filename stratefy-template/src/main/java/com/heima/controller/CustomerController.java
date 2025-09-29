package com.heima.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerController {

    @GetMapping("/customer/{recharge}")
    public String customer(@PathVariable(value = "recharge") int recharge){
        //分为普通用户 定制用户 尊享用户 至尊用户

        if(recharge >= 0 && recharge <= 50){
            return "该用户是普通用户";
        }

        if(recharge > 50 && recharge <= 100){
            return "该用户是定制用户";
        }

        if(recharge > 100 && recharge <= 200){
            return "该用户是尊享用户";
        }

        if(recharge > 200){
            return "该用户是至尊用户";
        }

        return "用户的充值额度出现异常";
    }
}
