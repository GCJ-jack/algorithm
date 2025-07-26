package com.itheima.BaseConverter;

import javax.xml.transform.Source;
import java.util.Scanner;

public class BaseConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 进制转换器（使用 enum + switch）===");


        try {

            System.out.print("请输入原始进制（2, 8, 10, 16）：");
            String fromInput = scanner.nextLine();
            BaseType fromBase = BaseType.toString(fromInput);

            System.out.print("请输入目标进制（2, 8, 10, 16）：");
            String toInput = scanner.nextLine();
            BaseType toBase = BaseType.toString(toInput);

            System.out.println("请输入你想要转换的数字：");
            String number = scanner.nextLine();

            String result;

            int decimalNumer = Integer.parseInt(number,fromBase.getValue());

            switch (toBase){
                case BINARY -> result = Integer.toBinaryString(decimalNumer);
                case OCTAL -> result = Integer.toOctalString(decimalNumer);
                case DECIMAL -> result = String.valueOf(decimalNumer);
                case HEX -> result = Integer.toHexString(decimalNumer);
                default -> result = "未知进制";
            }

            System.out.println(result);
        }catch (Exception e){
            System.out.println("输入有错误");
        }

    }
}
