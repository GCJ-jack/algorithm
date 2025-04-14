package com.itheima.dp;

public class solution1 {
    public String reverseMessage(String message) {
        // write code here
        String[] strings = message.split(" ");

        StringBuffer reversed = new StringBuffer();

        if(message.length() == 0){
            return "";
        }

        for(int i = strings.length - 1; i >= 0; i--) {
            reversed.append(strings[i]);
            if(i!=0){
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
    public static void main(String[] args) {

    }
}
