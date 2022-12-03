package com.power.study_2022_12;

import java.util.HashMap;

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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);
        return leftCount > rightCount ? leftCount + 1 : rightCount + 1;
    }
}
