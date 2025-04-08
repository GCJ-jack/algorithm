package com.itheima.stack;

public class leetcode155 {
    Stack<Integer> stack;
    Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty()||val<=min_stack.peek()){
            min_stack.push(val);
        }
    }

    public void pop() {

        if(stack.peek().equals(min_stack.peek())){
            min_stack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
