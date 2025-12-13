package com.itheima.tiktok;

public class longestPalindrome {

    public int solution(String s){
        //according to ascii to count how many times each letter appear
        int[] times = new int[128];

        for(char c: s.toCharArray()){
            times[c]++;
        }

        int maxLength = 0;
        boolean oddCountFound = false;

        for(int i:times){
            if(i % 2 == 0){
                maxLength += i;
            }else{
                maxLength += i - 1;
                oddCountFound = true;
            }
        }

        if(oddCountFound){
            maxLength++;
        }

        return maxLength;
    }

}
