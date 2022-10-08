package com.power.september_21;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo12 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        int len = str.length() + count * 2;

        int old_end = str.length() - 1;
        int new_end = len - 1;
        str.setLength(len);
        while (old_end >= 0 && new_end >= 0) {
            if (str.charAt(old_end) == ' ') {
                str.setCharAt(new_end--, '0');
                str.setCharAt(new_end--, '2');
                str.setCharAt(new_end--, '%');
                old_end--;
            } else {
                str.setCharAt(new_end--, str.charAt(old_end--));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
//        System.out.println(replaceSpace(new StringBuffer("we sss aaa")));
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0, 1);
        arrayList.add(0, 2);
        arrayList.add(0, 3);
        arrayList.add(0, 4);
        System.out.println(arrayList);
    }

    public TreeNode reConstructBinaryTree(ArrayList<Integer> pre, ArrayList<Integer> vin) {
        if (pre == null || vin == null || pre.size() != vin.size()) {
            return null;
        }
        return ww(pre, 0, pre.size() - 1, vin, 0, vin.size() - 1);
    }

    private TreeNode ww(ArrayList<Integer> pre, int pre_start, int pre_end, ArrayList<Integer> vin, int vin_start, int vin_end) {
        if (pre_start > pre_end || vin_start > vin_end) {
            return null;
        }
        TreeNode root = new TreeNode(pre.get(pre_start));
        for (int i = vin_start; i <= vin_end; i++) {
            if (pre.get(pre_start).equals(vin.get(i))) {
                root.left = ww(pre, pre_start + 1, pre_start + (i - vin_start), vin, vin_start, i - 1);
                root.right = ww(pre, pre_start + (i - vin_start) + 1, pre_end, vin, i + 1, vin_end);
                break;
            }
        }
        return root;
    }
}
