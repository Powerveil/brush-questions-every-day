package com.power.study_2022_12;

import java.util.Stack;

// 155. 最小栈
// https://leetcode.cn/problems/min-stack/
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.size() == 0) {
            stack.push(val);
            minStack.push(val);
        } else {
            int temp = minStack.peek();
            if (val <= temp) {
                minStack.push(val);
            }
            stack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }
    
    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}