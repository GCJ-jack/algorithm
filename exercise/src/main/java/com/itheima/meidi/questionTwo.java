package com.itheima.meidi;

import java.util.Scanner;

public class questionTwo {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // 注意 hasNext 和 hasNextLine 的区别
    // while (in.hasNextInt()) { // 注意 while 处理多个 case
    //     int a = in.nextInt();
    //     int b = in.nextInt();
    //     System.out.println(a + b);
    // }

    //读取九个数字放到数组中
    int[] arr = new int[9];
    for(int i = 0; i < 9; i++){
      arr[i] = in.nextInt();
    }

    //新的数组长度为9
    int[] newArr = new int[9];
    //将老数组每一位向后的移动三位超出的按余数计算放入
    for(int i = 0; i < 9; i++){
      newArr[(i + 3) % 9] = arr[i];
    }

    //打印新数组
    for(int i = 0; i < 9; i++){
      System.out.print(newArr[i] + " ");
    }
  }
}
