package com.itheima.array;

public class testHsbc {

    public static String compareNumber(int[] numbers){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length - 1; i++) {

            if (numbers[i] < numbers[i + 1]) {

                sb.append('<');
            } else if (numbers[i] > numbers[i + 1]) {

                sb.append('>');
            } else {

                sb.append('=');
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {


        System.out.println(compareNumber(new int[]{4, 3, 6, 6, 3}));  // 输出: ><=>
        System.out.println(compareNumber(new int[]{3, 2, 1, 1, 2, 3})); // 输出: >>=<<
    }
}
