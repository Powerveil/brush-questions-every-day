package com.power._2022.study_2022_12;

class MyHashSet {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;

    public MyHashSet() {
        head = null;
    }
    
    public void add(int key) {
        if (contains(key)) return;
        ListNode node = new ListNode(key);
        if (head == null) {
            head = node;
            return;
        }
        // 头插
        node.next = head;
        head = node;
    }
    
    public void remove(int key) {
        if (head == null) return;
        if (head.val == key) {
            head = null;
            return;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) return true;
            cur = cur.next;
        }
        return false;
    }
}