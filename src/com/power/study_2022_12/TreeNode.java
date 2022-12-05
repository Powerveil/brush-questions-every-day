package com.power.study_2022_12;

import java.util.Scanner;


// KY11 二叉树遍历
// https://www.nowcoder.com/practice/4b91205483694f449f94c179883c1fef?tpId=60&&tqId=29483&rp=1&ru=/activity/oj&qru=/ta/tsing-kaoyan/question-ranking
class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode(char val) {
        this.val = val;
    }
}

class Main {

    private int i = 0;

    private TreeNode create(String str) {
        if (str.charAt(i) == '#') {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(str.charAt(i++));
        root.left = create(str);
        root.right = create(str);
        return root;
    }

    private void order(TreeNode root) {
        if (root == null) return;
        order(root.left);
        System.out.print(root.val + " ");
        order(root.right);
    }

    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            Main m = new Main();
            TreeNode root = m.create(s);
            m.order(root);
        }
    }
}