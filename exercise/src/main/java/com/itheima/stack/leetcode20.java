package com.itheima.stack;

import com.itheima.linear.Stack;

import java.util.HashMap;
import java.util.Map;

public class leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> bracketsCount = new HashMap<>();

        bracketsCount.put(')', '(');
        bracketsCount.put(']', '[');
        bracketsCount.put('}', '{');

        for(int i = 0; i<s.length(); i++){
            char charC = s.charAt(i);
            if(bracketsCount.containsKey(charC)){
                if(stack.isEmpty()||stack.peek()!=bracketsCount.get(charC)){
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                stack.push(charC);
            }
        }


        return stack.isEmpty();
    }
}
