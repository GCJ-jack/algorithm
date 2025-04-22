package com.itheima.array;

import java.math.BigDecimal;

public class DecimalTest {

    public static void main(String[] args) {

        System.out.println(0.05 + 0.01);

        BigDecimal b = new BigDecimal("0.05");
        BigDecimal b1 = new BigDecimal("0.01");
        BigDecimal sum = b.add(b1);
        System.out.println(sum);
    }
}
