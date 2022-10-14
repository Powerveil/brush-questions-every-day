package com.power.test;

/**
 * @author 崔帅
 * @version 1.0
 */
public class MyLinkedList {
    Node head;
    int useSize;
    class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }


    private int Size() {
//        Node cur = head;
//        int count = 0;
//        while (cur != null) {
//            count++;
//            cur = cur.next;
//        }
//        return count;
        return useSize;
    }

    private void firstInsert(int val) {
        //将数据封装为Node节点
        Node node = new Node(val);
        node.next = head;
        head = node;
        //链表useSize增加
        useSize++;
    }

    private void lastInsert(int val) {
        //头节点为空为头插
        if (head == null) {
            firstInsert(val);
            return;
        }
        Node node = new Node(val);
        Node cur = head;
        //找到最后一个节点
        while (cur.next != null) cur = cur.next;
        //将最后一个节点的next置为node
        cur.next = node;
        node.next = null;
        //链表useSize增加
        useSize++;
    }

    private void printList() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val + " ");
            cur = cur.next;
        }
    }

    private void Insert(int index, int val) {
        if (index < 0 || index > useSize) {
            throw new MyException("下表错误");
        }
        if (index == 0) {
            firstInsert(val);
            return;
        }
        if (index == useSize) {
            lastInsert(val);
            return;
        }
        Node node = new Node(val);
        int count = 0;
        Node cur = head;

        while (cur.next != null) {
            if (++count == index) {
                node.next = cur.next;
                cur.next = node;
                return;
            }
            cur = cur.next;
        }
    }

    private void delete(int index) {
        if (head == null) throw new MyException("链表无数据，无法删除");

        if (index < 0 || index >= useSize) {
            throw new MyException("下表错误");
        }









        if (index == 0) {

        }

        int count = 0;
        Node cur = head;

        while (cur.next != null) {
            if (++count == index) {
                return;
            }
            cur = cur.next;
        }
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //测试头插
//        myLinkedList.firstInsert(1);
//        myLinkedList.firstInsert(12);
//        myLinkedList.firstInsert(13);
//        myLinkedList.printList();
        //测试尾插
//        myLinkedList.lastInsert(1);
//        myLinkedList.lastInsert(12);
//        myLinkedList.lastInsert(13);
//        myLinkedList.printList();
        //测试中间插
//        myLinkedList.Insert(0,1);
//        myLinkedList.Insert(0,2);
//        myLinkedList.Insert(0,23);
//
//        myLinkedList.Insert(3,50);
//        myLinkedList.Insert(2,50000);
//        myLinkedList.Insert(2,1000);
//        myLinkedList.Insert(2,1000555);
//        myLinkedList.printList();
    }


}
