package com.itheima.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class pddOne {
    Scanner in = new Scanner(System.in);
    // 注意 hasNext 和 hasNextLine 的区别
    // while (in.hasNextInt()) { // 注意 while 处理多个 case
    //     int a = in.nextInt();
    //     int b = in.nextInt();
    //     System.out.println(a + b);
    // }

    int numberRows = in.nextInt();
    int stringLength = in.nextInt();

    Set<String> set = new HashSet<>();

    int[] price = new int[7];
}
