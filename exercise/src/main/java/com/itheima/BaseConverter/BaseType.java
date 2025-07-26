package com.itheima.BaseConverter;

import java.security.PrivateKey;

public enum BaseType {

    BINARY(2),
    OCTAL(8),
    DECIMAL(10),
    HEX(16);



    private int value;


    public int getValue(){
        return value;
    }


    BaseType(int value){
        this.value = value;
    }

    public static BaseType toString(String s){
        switch (s.toLowerCase()){
            case "2": return BINARY;
            case "8": return OCTAL;
            case "10": return DECIMAL;
            case "16": return HEX;
            default: throw new IllegalArgumentException("不合法输入");
        }
    }

}
