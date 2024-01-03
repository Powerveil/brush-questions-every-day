package com.power._2022.study_2022_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }


//    private int preIndex = 0;
//    private TreeNode buildTree(int[] preorder, int[] inorder,int begainIndex, int endIndex) {
//        if (begainIndex > endIndex) return null;
//        TreeNode root = new TreeNode(preorder[preIndex]);
//
//        int inIndex = find(inorder,preorder[preIndex],begainIndex,endIndex);
//        if (inIndex == -1) return null;
//        preIndex++;
//        root.left = buildTree(preorder,inorder,begainIndex,inIndex-1);
//        root.right = buildTree(preorder,inorder,inIndex+1,endIndex);
//        return root;
//    }
//
//    private int find(int[] inorder, int target, int begainIndex, int endIndex) {
//        for (int i = begainIndex; i <= endIndex; i++) {
//            if (inorder[i] == target) return i;
//        }
//        return -1;
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return buildTree(preorder, inorder, 0,inorder.length - 1);
//    }



    private int postIndex = 0;
    private TreeNode buildTree(int[] postorder, int[] inorder,int begainIndex, int endIndex) {
        if (begainIndex > endIndex) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);

        int inIndex = find(inorder,postorder[postIndex],begainIndex,endIndex);
        if (inIndex == -1) return null;
        postIndex--;
        root.right = buildTree(postorder,inorder,inIndex+1,endIndex);
        root.left = buildTree(postorder,inorder,begainIndex,inIndex-1);
        return root;
    }

    private int find(int[] inorder, int target, int begainIndex, int endIndex) {
        for (int i = begainIndex; i <= endIndex; i++) {
            if (inorder[i] == target) return i;
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return buildTree(postorder, inorder, 0,inorder.length - 1);
    }


//    public String tree2str(TreeNode root) {
//        if (root == null) return "";
//        String s = root.val + "";
//        if (root.left != null) {
//            s += "(";
//            s += tree2str(root.left);
//            s += ")";
//        } else {
//            if (root.right == null) {
//                return s;
//            } else {
//                s += "()";
//            }
//        }
//        if (root.right != null) {
//            s += "(";
//            s += tree2str(root.right);
//            s += ")";
//        } else {
//            return s;
//        }
//        return s;
//    }


    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(root, sb);
        return sb.toString();
    }

    public void tree2strChild(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            tree2strChild(root.left, sb);
            sb.append(")");
        } else {
            if (root.right == null) {
                return;
            } else {
                sb.append("()");
            }
        }
        if (root.right == null) {
            return;
        } else {
            sb.append("(");
            tree2strChild(root.right, sb);
            sb.append(")");
        }

    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return list;
    }


    public List<Integer> inorderTraversal(TreeNode root) {

//        System.out.println("dsadas");
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            list.add(top.val);

            cur = top.right;
        }
        return list;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            if (top.right == null || prev == top.right) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                prev = pop;
            } else {
                cur = top.right;
            }
        }
        return list;
    }

}