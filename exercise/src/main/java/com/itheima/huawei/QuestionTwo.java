package com.itheima.huawei;

import java.util.Locale;
import java.util.Scanner;

public class QuestionTwo {

    static double floor4(double v){
        return Math.floor(v * 1000.0);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if(!scanner.hasNextLine()) return;

        String line = scanner.nextLine().trim();
        String[] parts = line.split("\\|",-1);
        String title = parts[0].trim().toLowerCase(Locale.ROOT);


    }
}
