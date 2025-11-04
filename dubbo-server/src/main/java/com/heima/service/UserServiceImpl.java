package com.heima.service;

import com.heima.model.User;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(interfaceClass = UserService.class, version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(int id) {

        System.out.println("using dubbo service");
        return User.builder()
                .id(1L)
                .name("junjun")
                .age(23)
                .build();
    }
}
