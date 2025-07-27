package com.itheima.BusinessException;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GirlFriend  girlFriend = new GirlFriend();

        System.out.println("请输入你在寻找的伴侣的名字与年龄：");

        while (true){
            try {
                System.out.println("请输入她的名字：");
                String name = scanner.nextLine();
                girlFriend.setName(name);
                System.out.println("请输入她的年龄");
                String age = scanner.nextLine();
                girlFriend.setAge(Integer.parseInt(age));
                break;
            }catch (NumberFormatException numberFormatException){
                System.out.println("输入的姓名长度有误");
            }catch (RuntimeException runtimeException){
                System.out.println("输入的年龄不合适");
            }
        }
    }
}
