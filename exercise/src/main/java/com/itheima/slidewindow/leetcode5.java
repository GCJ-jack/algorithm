package com.itheima.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class leetcode5 {
    public int lengthOfLongestSubstring(String s) {
        int maxString = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        //使用滑动窗口寻找最长无重复的子串
        for(int i=0; i<s.length(); i++){
            set.add(s.charAt(i));
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }

            maxString = Math.max(maxString, set.size());
        }
        return maxString;
    }
}
