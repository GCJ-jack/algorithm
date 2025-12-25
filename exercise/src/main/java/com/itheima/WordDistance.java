package com.itheima;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {

    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            map.computeIfAbsent(wordsDict[i], k-> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {


        List<Integer> a = map.get(word1);
        List<Integer> b = map.get(word2);

        int i = 0;
        int j = 0;

        int ans = Integer.MAX_VALUE;

        while (i < a.size() && j < b.size()) {
            int idx1 = a.get(i);
            int idx2 = b.get(j);

            ans = Math.min(ans, Math.abs(idx1 - idx2));

            if(idx1 < idx2){
                i++;
            }else{
                j++;
            }
        }

        return ans;
    }
}
