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
//        Arrays.sort(arr);//1 2 5 5 5 8
//        long sum = 0;
//        int index = arr.length - 2;
//        for (int i = 0; i < len; i++) {
//            sum += arr[index];
//            index -= 2;
//        }
//        System.out.println(sum);
//    }

    public static void main(String[] agrs) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < b.length(); i++) {
            set.add(b.charAt(i));
            //Thy r stdnts.
            //Thy r stdnts.
        }

        for (int i = 0; i < a.length(); i++) {
            if (!set.contains(a.charAt(i))) {
                sb.append(a.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
