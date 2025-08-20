package com.itheima.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateForm {

    public static boolean inBetween(LocalDate now,LocalDate start, LocalDate end){
        if(now.isAfter(start)&&now.isBefore(end)){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {


        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        LocalDate nationalDay = LocalDate.of(localDateTime.getYear(),10,1);

        System.out.println(nationalDay);

        LocalDate tomorrow = nationalDay.plusDays(1);

        LocalDate nextMonth = nationalDay.plusMonths(1);

        LocalDate nextYear = nationalDay.plusYears(1);

        System.out.println(tomorrow);

        System.out.println(nextMonth);

        System.out.println(nextYear);

        System.out.println(LocalDate.now().getYear());


        LocalTime localTime = LocalTime.now();

        System.out.println(localTime);

        Instant  instant = Instant.EPOCH;

        System.out.println(instant);

        long epochMillis = Instant.EPOCH.toEpochMilli();

        System.out.println(epochMillis);

        LocalDate start = LocalDate.of(2020,9,15);

        LocalDate end = LocalDate.of(2023,6,15);

        LocalDate now = LocalDate.now();

        if(now.isBefore(start)){
            System.out.println("you are now in the college yet");
        }else if (inBetween(now,start,end)){
            System.out.println("you are not graduate yet");
        }else if(now.isAfter(end)){
            System.out.println("congratulation, you are graduated");
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy--mm--dd hh:mm:ss");

        Date date = new Date();

        System.out.println(simpleDateFormat.format(date));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy--MM--dd hh:mm:ss");

        System.out.println(dateTimeFormatter.format(localDateTime));
    }
}
