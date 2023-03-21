package com.power.study_2023_3;

/**
 * @author power
 * @Date 2023/3/14 16:10
 */
public class Demo03 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }


    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        //任意一个链表为空，返回另一个
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        //反转两个链表
        head1 = reverse(head1);
        head2 = reverse(head2);
        //添加表头
        ListNode res = new ListNode(-1);
        ListNode head = res;
        //进位符号
        int carry = 0;
        //只要某个链表还有或者进位还有
        while (head1 != null || head2 != null || carry != 0) {
            //链表不为空则取其值
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            //相加
            int temp = val1 + val2 + carry;
            //获取进位
            carry = temp / 10;
            temp %= 10;
            //添加元素
            head.next = new ListNode(temp);
            head = head.next;
            //移动下一个
            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        //结果反转回来
        return reverse(res.next);
    }

    private int parseint(ListNode head) {
        int total = 0;
        while (head != null) {
            total *= 10;
            total += head.val;
            head = head.next;
        }
        return total;
    }


    private ListNode parseNode(int total) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        int len = getintLength(total);

        for (int i = 0; i < len; i++) {
            ListNode newNode = new ListNode(-1);
            newNode.val = (int) (total % 10);
            cur.next = newNode;
            cur = cur.next;
            total /= 10;
        }

        return head.next;
    }


    private int getintLength(int total) {
        int len = 1;
        while (total / 10 > 0) {
            total /= 10;
            len++;
        }
        return len;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode next = cur.next;
        head.next = null;
        while (next != null) {
            ListNode nodeNext = next.next;
            next.next = cur;
            cur = next;
            next = nodeNext;
        }
        return cur;
    }

    private void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }

}
