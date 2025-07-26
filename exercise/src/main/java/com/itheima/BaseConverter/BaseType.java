package com.itheima.BaseConverter;

public enum BaseType {

    BINARY(2),
    OCTAL(8),
    DECIMAL(10),
    HEX(16);

    private final int value;

    BaseType(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static BaseType fromString(String input){
        switch (input.toLowerCase()){
            case "2": case "binary": return BINARY;
            case "8": case "octal": return OCTAL;
            case "10": case "decimal": return DECIMAL;
            case "16": case "hex": case "hexadecimal": return HEX;
            default: throw new IllegalArgumentException("❌ 不支持的进制类型: " + input);
        }
    }



}
