package com.itheima.backTracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode17 {
    // 初始化 所有的字母组合
    List<String> letters;
    // 创立所有的数字到字母映射 0和1没有映射
    final String[] letterMap = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    /**
     * @param word 输入的电话号码
     */

    public List<String> letterCombinations(String digits) {
        letters = new ArrayList<String>();

        // 如果输入不符合条件 直接返回
        if(digits.length()==0){
            return letters;
        }

        // 通过回溯递归添加所有可能的字母组合
        findCombination("", digits, 0);

        return letters;
    }

    /**
     * @param letter 字母的组合
     * @param digits 输入的电话
     * @param index 创立分节点
     */
    public void findCombination(String letter, String digits, Integer index){
        // 如果节点后没有可以添加的字母添加到集合中
        if(index==digits.length()){
            letters.add(letter);
            return;
        }
        // 根据节点层数寻找可以映射的字母
        char c = digits.charAt(index);
        String letterSet = letterMap[c - '0'];

        for(int i = 0; i < letterSet.length(); i++){
            findCombination(letter + letterSet.charAt(i), digits, index + 1);
        }
    }
}
