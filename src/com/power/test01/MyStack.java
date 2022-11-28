package com.power.test01;

import java.util.*;

class MyStack {

    private Queue<Integer> que1;
    private Queue<Integer> que2;
    public MyStack() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if (!que1.isEmpty()) {
            que1.offer(x);
        } else if (!que2.isEmpty()) {
            que2.offer(x);
        } else {
            que1.offer(x);
        }
    }
    
    public int pop() {
        if (empty()) return -1;
        if (!que1.isEmpty()) {
            int len = que1.size();
            for (int i = 0; i < len - 1; i++) {
                que2.offer(que1.poll());
            }
            return que1.poll();
        } else {
            int len = que2.size() - 1;
            for (int i = 0; i < len; i++) {
                que1.offer(que2.poll());
            }
            return que2.poll();
        }
    }
    
    public int top() {
        if (!que1.isEmpty()) {
            int len = que1.size();
            for (int i = 0; i < len - 1; i++) {
                que2.offer(que1.poll());
            }
            int temp = que1.poll();
            que2.offer(temp);
            return temp;
        } else if (!que2.isEmpty()) {
            int len = que2.size() - 1;
            for (int i = 0; i < len; i++) {
                que1.offer(que2.poll());
            }
            int temp = que2.poll();
            que1.offer(temp);
            return temp;
        }
        return -1;
    }
    
    public boolean empty() {
        return que1.isEmpty() && que2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */