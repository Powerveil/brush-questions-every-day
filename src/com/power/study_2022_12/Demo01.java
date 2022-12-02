package com.power.study_2022_12;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     *
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

//    public static void main(String[] args) {
//        MyHashSet myHashSet = new MyHashSet();
////        myHashSet.add(1);
////        myHashSet.add(2);
////        System.out.println(myHashSet.contains(1));
////        System.out.println(myHashSet.contains(3));
////        myHashSet.add(2);
////        System.out.println(myHashSet.contains(2));
////        myHashSet.remove(2);
////        System.out.println(myHashSet.contains(2));
////        myHashSet.add(1000000);
////        System.out.println(myHashSet.contains(1000000));
//
//        myHashSet.add(50);
//        System.out.println(myHashSet.contains(0));
//    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            char p = stack.pop();
            if ((p == '[' && c == ']') || (p == '(' && c == ')') || (p == '{' && c == '}')) {
                ;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

//    public static void main(String[] args) {
////        System.out.println(isValid("()"));
////        System.out.println(Integer.parseInt("a"));
////        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
//        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[] {4,5,3,2,1}));
//        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[] {4,3,5,1,2}));
//    }

    //    逆骨版C++
    //    bool isValid(string s) {
    //        if (s.size() % 2 != 0) return false; // 如果s的长度为奇数，一定不符合要求
    //        stack<char> st;
    //        for (int i = 0; i < s.size(); i++) {
    //            if (s[i] == '(') st.push(')');
    //            else if (s[i] == '{') st.push('}');
    //            else if (s[i] == '[') st.push(']');
    //            // 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号 return false
    //            // 第二种情况：遍历字符串匹配的过程中，发现栈里没有我们要匹配的字符。所以return false
    //            else if (st.empty() || st.top() != s[i]) return false;
    //            else st.pop(); // st.top() 与 s[i]相等，栈弹出元素
    //        }
    //        // 第一种情况：此时我们已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false，否则就return true
    //        return st.empty();
    //    }


    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!ww(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int number1 = stack.pop();
                int number2 = stack.pop();
                stack.push(qq(number2,number1,tokens[i]));
            }
        }
        return stack.pop();
    }

    private static boolean ww(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }


    private static int qq(int p1, int p2, String operation) {
        if ("+".equals(operation)) return p1 + p2;
        else if ("-".equals(operation)) return p1 - p2;
        else if ("*".equals(operation)) return p1 * p2;
        else if ("/".equals(operation)) return p1 / p2;
        else return -1;
    }


//    public static boolean IsPopOrder(int [] pushA,int [] popA) {
//        Stack<Integer> stack = new Stack<>();
//        int i = 0;
//        int j = 0;
//        while (true) {
//            if (stack.isEmpty()) {
//                if (j == popA.length) return true;
//                stack.push(pushA[i++]);
//            } else {
//                int temp = stack.peek();
//                if (temp == popA[j]) {
//                    j++;
//                    stack.pop();
//                } else {
//                    if (i >= popA.length) return false;
//                    stack.push(pushA[i++]);
//                }
//            }
//        }
//    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);

            while (j < popA.length && !stack.isEmpty() && stack.peek().equals(popA[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.size()); // 获取栈中有效元素个数---> 4
        System.out.println(s.peek()); // 获取栈顶元素---> 4
        s.pop(); // 4出栈，栈中剩余1 2 3，栈顶元素为3
        System.out.println(s.pop()); // 3出栈，栈中剩余1 2 栈顶元素为3
        if(s.empty()){
            System.out.println("栈空");
        }else{
            System.out.println(s.size());
        }
    }

    // 前序遍历
    // https://leetcode.cn/problems/binary-tree-preorder-traversal/submissions/
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root != null) {
//            list.add(root.val);
//            list.addAll(preorderTraversal(root.left));
//            list.addAll(preorderTraversal(root.right));
//        }
//        return list;
//    }

    // 中序遍历
    // https://leetcode.cn/problems/binary-tree-inorder-traversal/submissions/
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root != null) {
//            list.addAll(inorderTraversal(root.left));
//            list.add(root.val);
//            list.addAll(inorderTraversal(root.right));
//        }
//        return list;
//    }

    // 后序遍历
    // https://leetcode.cn/problems/binary-tree-postorder-traversal/submissions/
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root != null) {
//            list.addAll(postorderTraversal(root.left));
//            list.addAll(postorderTraversal(root.right));
//            list.add(root.val);
//        }
//        return list;
//    }
}
