package com.power.test01;

import java.util.Arrays;

//class MyQueue {
//
//    private Stack<Integer> stack1;
//    private Stack<Integer> stack2;
//    public MyQueue() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//    }
//
//    public void push(int x) {
//        stack1.push(x);
//    }
//
//    public int pop() {
//        if (empty()) return -1;
//        if (!stack2.isEmpty()) return stack2.pop();
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        return stack2.pop();
//    }
//
//    public int peek() {
//        if (empty()) return -1;
//        if (!stack2.isEmpty()) return stack2.peek();
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        return stack2.peek();
//    }
//
//    public boolean empty() {
//        return stack1.isEmpty() && stack2.isEmpty();
//    }
//}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


class MyQueue {
    private int[] elements; // 元素数组
    private int front; // 队列尾部下标
    private int rear; // 队列头部的下一个下标
    private static final int DEFAULT_CAPACITY = 10; // 默认扩容数量 ArrayList
    private static final float DEFAULT_LOAD_FACTOR = 0.75f; // 默认加载因子 HashMap

    // 无参构造
    public MyQueue() {
        elements = new int[DEFAULT_CAPACITY];
    }

    // 有参构造
    public MyQueue(int capacity) {
        elements = new int[capacity];
    }

    // 检查容量
    private void checkCapacity() {
        if (elementsTouchThreshold()) {
            grow();
        }
    }

    // 判断是否需要扩容
    private boolean elementsTouchThreshold() {
        int threshold = (int) (DEFAULT_LOAD_FACTOR * elements.length);
        return rear >= threshold;
    }

    // 扩容
    private void grow() {
        int oldCapacity = elements.length;
        int newCapacity = (oldCapacity + oldCapacity >> 1);
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // 向队列头插入元素
    public void push(int x) {
        checkCapacity();
        elements[rear++] = x;
    }

    // 弹出队列尾元素
    public int pop() {
        if (empty()) throw  new OutOfTheRangeException("队列为空"); // 自定义异常
        return elements[front++];
    }

    // 查看队列尾元素
    public int peek() {
        if (empty()) throw new OutOfTheRangeException("队列为空"); // 自定义异常
        return elements[front];
    }

    // 判断队列是否为空
    public boolean empty() {
        return front == rear;
    }
}