package com.power.study_2022_12;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author power
 * @Date 2022/12/13 20:54
 */
public class Demo04 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int len = stack.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode cur = pre.next;
        head.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }


    // 方法一：回溯 + 哈希表
//    HashMap<ListNode,ListNode> hashMap = new HashMap<>();
//    public ListNode copyRandomList(ListNode head) {
//        if (head == null) return null;
//        if(!hashMap.containsKey(head)) {
//            ListNode newNode = new ListNode(head.val);
//            hashMap.put(head,newNode);
//            newNode.next = copyRandomList(head.next);
//            newNode.random = copyRandomList(head.random);
//        }
//        return hashMap.get(head);
//    }

    // 方法二：迭代 + 节点拆分
    public ListNode copyRandomList(ListNode head) {
        if (head == null) return head;
        for (ListNode node = head; node != null; node = node.next.next) {
            ListNode newNode = new ListNode(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        for (ListNode node = head; node != null; node = node.next.next) {
            ListNode newNode = node.next;
            newNode.random = node.random != null ? node.random.next : null;
        }

        ListNode result = head.next;
        for (ListNode node = head; node != null; node = node.next) {
            ListNode newNode = node.next;
            node.next = newNode.next;
            newNode.next = node.next != null ? node.next.next : null;
        }

        return result;
    }


//    public static String replaceSpace(String s) {
//        int count = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (' ' == s.charAt(i)) count++;
//        }
//        char[] chars = new char[s.length() + count * 2];
//        int j = 0;
//        for (int i = 0; i < s.length() ; i++) {
//            if (' ' == s.charAt(i)) {
//                chars[j++] = '%';
//                chars[j++] = '2';
//                chars[j++] = '0';
//            } else {
//                chars[j++] = s.charAt(i);
//            }
//        }
//        return new String(chars);
//    }


    public static String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
//        "".getChars();
//        String s = new String()
        System.out.println(replaceSpace("We are happy."));
    }


//    public String reverseLeftWords(String s, int n) {
//        return
//    }
}
