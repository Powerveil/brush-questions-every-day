package com.power.september_21;

import java.util.*;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo13 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
//        int[] arr = new int[len * 3];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = in.nextInt();
//        }
//        java.util.Arrays.sort(arr);//1 2 5 5 5 8
//        long sum = 0;
//        int index = arr.length - 2;
//        for (int i = 0; i < len; i++) {
//            sum += arr[index];
//            index -= 2;
//        }
//        System.out.println(sum);
//    }

//    public static void main(String[] agrs) {
//        Scanner in = new Scanner(System.in);
//        String a = in.nextLine();
//        String b = in.nextLine();
//        StringBuilder sb = new StringBuilder();
//        HashSet<Character> set = new HashSet<>();
//        for (int i = 0; i < b.length(); i++) {
//            set.add(b.charAt(i));
//            //Thy r stdnts.
//            //Thy r stdnts.
//        }
//
//        for (int i = 0; i < a.length(); i++) {
//            if (!set.contains(a.charAt(i))) {
//                sb.append(a.charAt(i));
//            }
//        }
//        System.out.println(sb.toString());
//    }


//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || preorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        int inorderIndex = 0;
//        for (int i = 1; i < preorder.length; i++) {
//            int preorderVal = preorder[i];
//            TreeNode node = stack.peek();
//            if (node.val != inorder[inorderIndex]) {
//                node.left = new TreeNode(preorderVal);
//                stack.push(node.left);
//            } else {
//                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
//                    node = stack.pop();
//                    inorderIndex++;
//                }
//                node.right = new TreeNode(preorderVal);
//                stack.push(node.right);
//            }
//        }
//        return root;
//    }


//    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        Integer peek = stack.peek();
//        System.out.println(peek);
//    }



    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return ww(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
//    }
//
//    private TreeNode ww(int[] pre, int pre_start, int pre_end, int[] in, int in_start, int in_end) {
//        if (pre_start > pre_end || in_start > in_end) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(pre[pre_start]);
//
//        for (int i = in_start; i <= in_end; i++) {
//            if (pre[pre_start] == in[i]) {
//                root.left = ww(pre, pre_start + 1, pre_start  + i - in_start, in, in_start, i - 1);
//                root.right = ww(pre, pre_start + i - in_start + 1, pre_end, in, i + 1, in_end);
//                break;
//            }
//        }
//
//        return root;
//    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        long first = 1;
        long second = 1;
        long third = 0;
        long ww = 1000000007;//1111111111111111
        while (n > 2) {
            third = first + second;
            second = first;
            first = third;
            n--;
        }
        return (int)(third % ww);
    }


    public static void main(String[] args) {
        System.out.println(fib(93));
    }
}
