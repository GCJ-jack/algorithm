package com.itheima.meidi;

import java.util.Scanner;

public class questionThree {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // 注意 hasNext 和 hasNextLine 的区别
    // 输入 ab1c2d, 1, 1.1
    // 输出 14.1
    String a = in.nextLine();
    String[] b = a.split(",");
    double num = 0;
    for (int i = 0; i < b.length; i++) {
      // 提取数字并保持原始格式
      String current = b[i].replaceAll("[^0-9.]", "");
      if (current.contains(".")) {
        // 如果是小数，直接解析
        num += Double.parseDouble(current);
      } else if (!current.isEmpty()) {
        // 如果是整数，直接解析整个数字
        num += Double.parseDouble(current);
      }
    }
    System.out.println(num);
  }
}
