package com.itheima.String;

public class StringDifference {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        s1 = s1.concat(s2);
        System.out.println(s1);


        StringBuffer sb = new StringBuffer("abc");
        sb.append("nihao");
    }
}
