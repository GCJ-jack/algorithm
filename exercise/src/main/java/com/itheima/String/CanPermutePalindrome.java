package com.itheima.String;

import java.util.HashSet;
import java.util.Set;

public class CanPermutePalindrome {

    public boolean canPermutePalindrome(String s){
//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if(set.contains(s.charAt(i))){
//                set.remove(s.charAt(i));
//            }else{
//                set.add(s.charAt(i));
//            }
//        }
//
//        return set.size() <= 1;
        
        int[] cnt = new int[128];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
        }

        int odd = 0;

        for(int x:cnt){
            if((x & 1) == 1){
                odd++;
            }
            if(odd > 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
