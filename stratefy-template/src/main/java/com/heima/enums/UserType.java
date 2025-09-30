package com.heima.enums;

import jdk.vm.ci.meta.Value;

import java.util.function.IntPredicate;

public enum UserType {

    NORMAL( recharge -> recharge >= 0 && recharge <= 50),
    PERSONAL(recharge-> recharge > 50 && recharge <= 100),
    SMALL(recharge -> recharge > 100 && recharge <= 200),
    BIG(recharge -> recharge > 200);

    private final IntPredicate support;

    UserType(IntPredicate support){
        this.support = support;
    }

    public static UserType typeOf(int recharge){
        for (UserType userType:values()){
            if(userType.support.test(recharge)){
                return  userType;
            }
        }
        return null;
    }
}
