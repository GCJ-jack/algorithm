package com.itheima.date;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateForm {

    public static void main(String[] args) {


        LocalDateTime localDateTime = LocalDateTime.now();


        System.out.println(localDateTime);

        LocalDate nationalDay = LocalDate.of(localDateTime.getYear(),10,1);

        System.out.println(nationalDay);
    }
}
