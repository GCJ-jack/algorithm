package com.itheima.stack;

public class leetcode394 {
    public String decodeString(String s) {
        int multi = 0;
        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_res = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(Character c: s.toCharArray()){
            if(c=='['){
                // 遇到左括号，把当前multi和res入栈，并重置
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(c==']'){
                // 遇到右括号，出栈并拼接字符串
                StringBuilder temp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for(int i = 0; i < cur_multi;i++){
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + temp.toString());
            }else if(Character.isDigit(c)){
                // 处理数字（可能有多位）
                multi = multi * 10 + (c - '0');
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
