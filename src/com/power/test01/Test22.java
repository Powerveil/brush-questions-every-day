package com.power.test01;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Test22 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        myQueue.push(6);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
//        LinkedList
    }
}
