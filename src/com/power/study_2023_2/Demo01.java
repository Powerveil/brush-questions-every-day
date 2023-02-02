package com.power.study_2023_2;

import com.sun.org.apache.bcel.internal.generic.RETURN;

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

    private ListNode mergeList(List<ListNode> lists, int left, int right) {
        if (left == right) return lists.get(left);
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        return merge(mergeList(lists, left, mid), mergeList(lists, mid + 1, right));
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null) return null;
        ListNode start  = pHead;
        while (true) {
            if (start == slow) return start;
            start = start.next;
            slow = slow.next;
        }
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if (k <= 0) return null;
        ListNode cur = pHead;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        if (k > count) return null;
        count -= k;
        cur = pHead;
        while (count > 0) {
            cur = cur.next;
            count--;
        }
        return cur;
    }


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == pHead2) return pHead1;
        if (pHead1 == null || pHead2 == null) return null;
        int count1 = 0;
        int count2 = 0;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1 != null) {
            cur1 = cur1.next;
            count1++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            count2++;
        }
        cur1 = pHead1;
        cur2 = pHead2;
        int count = 0;
        if (count1 > count2) {
            count = count1 - count2;
            while (count > 0) {
                cur1 = cur1.next;
                count--;
            }
        } else {
            count = count2 - count1;
            while (count > 0) {
                cur2 = cur2.next;
                count--;
            }
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

}
