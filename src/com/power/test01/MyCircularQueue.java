package com.power.test01;

//class MyCircularQueue {
//    int[] elements;
//    int front;
//    int rear;
//
//    public MyCircularQueue(int k) {
//        elements = new int[k + 1];
//    }
//
//    public boolean enQueue(int value) {
//        if (isFull()) return false;
//        elements[rear] = value;
//
//        rear = (rear + 1) % elements.length;
//        return true;
//    }
//
//    public boolean deQueue() {
//        if (isEmpty()) return false;
//        front = (front + 1) % elements.length;
//        return true;
//    }
//
//    public int Front() {
//        if (isEmpty()) return -1;
//        return elements[front];
//    }
//
//    public int Rear() {
//        if (isEmpty()) return -1;
//        if (rear == 0) return elements[elements.length - 1];
//        return elements[rear - 1];
//    }
//
//    public boolean isEmpty() {
//        return front == rear;
//    }
//
//    public boolean isFull() {
//        return (rear + 1) % elements.length == front;
//    }
//}

class MyCircularQueue {
    int[] elements;
    int front;
    int rear;
    int usedSize;

    public MyCircularQueue(int k) {
        elements = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        elements[rear] = value;
        usedSize++;
        rear = (rear + 1) % elements.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % elements.length;
        usedSize--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return elements[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return elements[(rear - 1 + elements.length) % elements.length];
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public boolean isFull() {
        return usedSize == elements.length;
    }
}