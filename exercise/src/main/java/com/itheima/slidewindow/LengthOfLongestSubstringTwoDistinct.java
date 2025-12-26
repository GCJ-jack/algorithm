package com.itheima.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int maxLen = 0;

        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }

                left++;
            }

            maxLen = Math.max(maxLen,i - left + 1);
        }

        return maxLen;
    }

}
