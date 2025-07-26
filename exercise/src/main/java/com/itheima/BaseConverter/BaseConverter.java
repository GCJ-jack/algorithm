package com.itheima.BaseConverter;

import java.util.Scanner;

public class BaseConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 进制转换器（使用 enum + switch）===");


        try {
            System.out.print("请输入原始进制（2, 8, 10, 16）：");
            String fromInput = scanner.nextLine();
            BaseType fromBase = BaseType.fromString(fromInput);

            System.out.print("请输入目标进制（2, 8, 10, 16）：");
            String toInput = scanner.nextLine();
            BaseType toBase = BaseType.fromString(toInput);


            System.out.print("请输入要转换的数字：");
            String number = scanner.nextLine();


            String result;

            //转换成十进制
            int decimalValue = Integer.parseInt(number, fromBase.getValue());

            switch (toBase){
                case HEX -> result = Integer.toHexString(decimalValue);
                case OCTAL -> Integer.toOctalString(decimalValue);
                case BINARY -> Integer.toBinaryString(decimalValue);
                case DECIMAL -> Integer.toString(decimalValue);
                default -> result = "未知进制";
            }

        }catch (Exception e){
            System.out.println("❌ 输入有误：" + e.getMessage());
        }

    }
}
