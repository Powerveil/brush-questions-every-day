package com.power.study_2022_12;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo01 {

    static class ListNode {
        int val;
        ListNode next;

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
    //力扣：83. 删除排序链表中的重复元素
    //https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
    /**
     * 给定一个已排序的链表的头 head
     * 删除所有重复的元素，使每个元素只出现一次
     * 返回 已排序的链表
     * @param head 已排序的链表的头
     * @return 已排序的链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
//        myHashSet.add(1);
//        myHashSet.add(2);
//        System.out.println(myHashSet.contains(1));
//        System.out.println(myHashSet.contains(3));
//        myHashSet.add(2);
//        System.out.println(myHashSet.contains(2));
//        myHashSet.remove(2);
//        System.out.println(myHashSet.contains(2));
//        myHashSet.add(1000000);
//        System.out.println(myHashSet.contains(1000000));

        myHashSet.add(50);
        System.out.println(myHashSet.contains(0));
    }
}
