package com.power._2022.study_2022_12;

import java.util.*;

/**
 * @author 崔帅
 * @version 1.0
 */

public class Demo02 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 100. 相同的树
    // https://leetcode.cn/problems/same-tree/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (q == null || p == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 572. 另一棵树的子树
    // https://leetcode.cn/problems/subtree-of-another-tree/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        boolean b1 = isSameTree(root, subRoot);
        if (b1) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    // 104. 二叉树的最大深度
    // https://leetcode.cn/problems/maximum-depth-of-binary-tree/
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        int leftCount = maxDepth(root.left);
//        int rightCount = maxDepth(root.right);
//        return leftCount > rightCount ? leftCount + 1 : rightCount + 1;
//    }

//    public static void main(String[] args) {
//        int a = 10;
//
//    }


    // 110. 平衡二叉树
    // https://leetcode.cn/problems/balanced-binary-tree/
    // 方法一
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        int leftCount = maxDepth(root.left);
//        int rightCount = maxDepth(root.right);
//        return Math.abs(leftCount - rightCount) > 1 ? false : (isBalanced(root.left) && isBalanced(root.right));
//    }
    // 方法二
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return maxDepth(root) != -1;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);
        if (leftCount >= 0 && rightCount >= 0 && Math.abs(leftCount - rightCount) <= 1) {
            return Math.max(leftCount,rightCount) + 1;
        } else {
            return -1;
        }
    }

    // 101. 对称二叉树
    // https://leetcode.cn/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSame(root.left,root.right);
    }

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
    }

    // 层序遍历
//    private void levelOrder(TreeNode root) {
//        if (root == null) return;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.poll();
//            System.out.println(cur + " ");
//            if (cur.left != null) {
//                queue.offer(cur.left);
//            }
//            if (cur.right != null) {
//                queue.offer(cur.right);
//            }
//        }
//    }

    // 102. 二叉树的层序遍历
    // https://leetcode.cn/problems/binary-tree-level-order-traversal/
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ret = new ArrayList<>();
//        if (root == null) return ret;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            List<TreeNode> list = new ArrayList<>();
//            List<Integer> list2 = new ArrayList<>();
//            while (!queue.isEmpty()) {
//                TreeNode poll = queue.poll();
//                list.add(poll);
//                list2.add(poll.val);
//            }
//            for (TreeNode cur : list) {
//                if (cur.left != null) {
//                    queue.offer(cur.left);
//                }
//                if (cur.right != null) {
//                    queue.offer(cur.right);
//                }
//            }
//            ret.add(list2);
//        }
//        return ret;
//    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                size--;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }


    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }

    // 236. 二叉树的最近公共祖先
    // https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return null;
//        if (root == p || root == q) return root;
//        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
//        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
//        if (leftNode != null && rightNode != null) {
//            return root;
//        } else if (leftNode != null) {
//            return leftNode;
//        } else if (rightNode != null) {
//            return rightNode;
//        } else {
//            return null;
//        }
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root,p,stack1);
        getPath(root,q,stack2);
        int size = 0;
        if (stack1.size() > stack2.size()) {
            size = stack1.size() - stack2.size();
            while (size > 0) {
                size--;
                stack1.pop();
            }
        } else {
            size = stack2.size() - stack1.size();
            while (size > 0) {
                size--;
                stack2.pop();
            }
        }
        while (!stack1.isEmpty()) {
            TreeNode t1 = stack1.pop();
            TreeNode t2 = stack2.pop();
            if (t1 == t2) return t1;
        }
        return null;
    }

    private boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null || node == null) return false;
        stack.push(root);
        if (root == node) return true;
        boolean b1 = getPath(root.left, node, stack);
        if (b1) return true;
        boolean b2 = getPath(root.right, node, stack);
        if (b2) return true;
        stack.pop();
        return false;
    }

    // JZ36 二叉搜索树与双向链表
    // https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&&tqId=11179&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
    // left -> pre
    // right -> next
    private TreeNode prev = null;
    public TreeNode Convert(TreeNode root) {
        if (root == null) return null;
        ConvertChild(root);
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    private void ConvertChild(TreeNode root) {
        if (root == null) return;
        ConvertChild(root.left);
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        ConvertChild(root.right);
    }


}

