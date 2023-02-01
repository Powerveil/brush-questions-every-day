package com.power.study_2023_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author power
 * @Date 2023/2/1 19:54
 */
public class Demo01 {

    public static class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode end) {
        if (head == end || head.next == end) return head;
        ListNode pre = head;
        ListNode cur = pre.next;
        head.next = null;
        while (cur != end) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }

//    private ListNode reverse(ListNode head, ListNode tail) {
//        ListNode pre = null;
//        ListNode next = null;
//        while (head != tail) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }

//    public ListNode Merge(ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        }
//        if (list2 == null) {
//            return list1;
//        }
//        ListNode newHead;
//        if (list1.val < list2.val) {
//            newHead = list1;
//            list1 = list1.next;
//        } else {
//            newHead = list2;
//            list2 = list2.next;
//        }
//        ListNode newList = newHead;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                newList.next = list1;
//                list1 = list1.next;
//            } else {
//                newList.next = list2;
//                list2 = list2.next;
//            }
//            newList = newList.next;
//        }
//        while (list1 != null) {
//            newList.next = list1;
//            list1 = list1.next;
//            newList = newList.next;
//        }
//        while (list2 != null) {
//            newList.next = list2;
//            list2 = list2.next;
//            newList = newList.next;
//        }
//        return newHead;
//    }

//    public ListNode Merge(ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        } else if (list2 == null) {
//            return list1;
//        }
//        if (list2.val > list1.val) {
//            list1.next = Merge(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = Merge(list1, list2.next);
//            return list2;
//        }
//    }


    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        // 必须保证两个list都不为空
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            } else if (list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            }
        }
        // list1后面还有，就把剩下的全部拿走
        if (list1 != null) {
            dummy.next = list1;
        }
        if (list2 != null) {
            dummy.next = list2;
        }
        return res.next;
    }


    public ListNode mergeKLists(List<ListNode> lists) {
        return mergeList(lists, 0, lists.size() - 1);
    }

    public ListNode mergeList(List<ListNode> lists, int left, int right) {
        if (left == right) return lists.get(left);
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        return merge(mergeList(lists, left, mid), mergeList(lists, mid + 1, right));
    }

    //合并两个有序链表（和力扣的21题一样）
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

}
