package com.heima.controller;


import com.heima.model.User;
import com.heima.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @DubboReference
    UserService userService;


    @GetMapping("user")
    public User getUser(){
        return userService.getUser(1);
    }

}
