package com.heima.controller;


import com.heima.model.User;
import com.heima.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @DubboReference(
            url = "dubbo://127.0.0.1:20880",
            check = false,
            version = "1.0.0"  // 明确指定版本号
    )    UserService userService;


    @GetMapping("user")
    public User getUser(){
        return userService.getUser(1);
    }

}
