package com.power.study_2022_12;

import java.util.*;

/**
 * @author power
 * @Date 2022/12/16 18:06
 */
public class Demo05 {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public static String reverseLeftWords(String s, int n) {
//        if (n == 0) return s;
//        n %= s.length();
//        return s.substring(n) + s.substring(0,n);
//    }

//    public static void main(String[] args) {
//        System.out.println(reverseLeftWords("abcdefg", 2));
//    }

    public static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    public static int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

//    public int search(int[] nums, int target) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num : nums) {
//            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
//        }
//        return hashMap.getOrDefault(target, -1);
//    }

//    public int search(int[] nums, int target) {
//        int count = 0;
//        for (int num : nums) {
//            if (target == num) count++;
//        }
//        return count;
//    }


    public int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

//    public int missingNumber(int[] nums) {
//        int sum = 0;
//        for (int num : nums) sum += num;
//        return (1 + nums.length) * nums.length / 2 - sum;
//    }

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (mid == nums[mid]) {
                left = mid + 1; // 左边全部符合条件 | 最后(left == right)如果相等说明mid+1位置空缺
            } else {
                right = mid - 1; // 右边全部符合条件 | 最后(left == right)如果相等说明left位置空缺 直接退出循环即可
            }
        }
        return left;
    }

//    public static void main(String[] args) {
////        System.out.println((-1 >> 1)); // -1
////        System.out.println((-1 >>> 1)); // 2147483647
//        System.out.println(aa(1,7));
//
//    }

    private static int aa(int left, int right) {
//        int k = left + (right - left) / 2;
        return left + (right - left >> 1);
    }


//    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
//        int ww = matrix.length - 1;
//        while (ww >= 0) {
//            if (target >= matrix[ww][0]) {
//                break;
//            }
//            ww--;
//        }
//        if (ww < 0) return false;
//        for (int i = 0; i < matrix[ww].length; i++) {
//            if (matrix[ww][i] == target) return true;
//        }
//        return false;
//    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }


//    public static void main(String[] args) {
//        System.out.println(findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
//    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    //    public char firstUniqChar(String s) {
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
//        }
//        for (char c : s.toCharArray()) {
//            if (hashMap.get(c) == 1) return c;
//        }
//        return ' ';
//    }


//    public char firstUniqChar(String s) {
//        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for (Character c : map.keySet()) {
//            if (map.get(c) == 1) {
//                return c;
//            }
//        }
//        return ' ';
//    }


    public static char firstUniqChar(String s) {
        int n = s.length();
        LinkedList<Character> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                queue.offer(c);
            }
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.remove(new Character(c));
                map.put(c, -1);
            }
        }

        return queue.isEmpty() ? ' ' : queue.peek();
    }


//    public int[] levelOrder(TreeNode root) {
//        if (root == null) return new int[]{};
//        LinkedList<TreeNode> linkedList = new LinkedList<>();
//        List<Integer> list = new ArrayList<>();
//        linkedList.offer(root);
//        while (!linkedList.isEmpty()) {
//            TreeNode poll = linkedList.poll();
//            list.add(poll.val);
//            if (poll.left != null) {
//                linkedList.offer(poll.left);
//            }
//
//            if (poll.right != null) {
//                linkedList.offer(poll.right);
//            }
//        }
//
//        int[] arr = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = list.get(i);
//        }
//        return arr;
//    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null) return result;
//        LinkedList<TreeNode> linkedList = new LinkedList<>();
//        linkedList.offer(root);
//        while (!linkedList.isEmpty()) {
//            List<Integer> list = new ArrayList<>();
//            int len = linkedList.size();
//            for (int i = 0; i < len; i++) {
//                TreeNode poll = linkedList.poll();
//                list.add(poll.val);
//                if (poll.left != null) {
//                    linkedList.offer(poll.left);
//                }
//                if (poll.right != null) {
//                    linkedList.offer(poll.right);
//                }
//            }
//            result.add(list);
//        }
//        return result;
//    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if ((result.size() & 1) == 1) list.addFirst(poll.val);
                else list.addLast(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            result.add(list);
        }
        return result;
    }


//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if (A == null && B != null) return false;
//        if (B == null) return false;
//        if (isSame(A, B)) return true;
//        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
//    }
//
//    private boolean isSame(TreeNode A, TreeNode B) {
//        if (A == null && B != null) return false;
//        if (B == null) return true;
//        if (A.val != B.val) return false;
//        return isSame(A.left, B.left) && isSame(A.right, B.right);
//    }



    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return isSame(root.left, root.right);
//    }
//
//    private boolean isSame(TreeNode p1, TreeNode p2) {
//        if (p1 == null && p2 == null) return true;
//        if (p1 == null || p2 == null) return false;
//        if (p1.val != p2.val) return false;
//        return isSame(p1.left, p2.right) && isSame(p1.right, p2.left);
//    }


    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    private boolean isSame(TreeNode p1, TreeNode p2) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(p1);
        list.offer(p2);
        while (!list.isEmpty()) {
            TreeNode t1 = list.poll();
            TreeNode t2 = list.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null || t1.val != t2.val) return false;

            list.offer(t1.left);
            list.offer(t2.right);
            list.offer(t1.right);
            list.offer(t2.left);
        }
        return true;
    }

    public int fib(int n) {
        int a = 0;
        int b = 1;
        while (n-- > 0) {
            int c = b;
            b = a + b;
            a = c;
            b %= 1000000007;
        }
        return a;
    }

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public int maxValue(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }


        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }


        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[grid.length - 1][(grid[grid.length - 1].length - 1)];
    }

//    public static void main(String[] args) {
////        Math.round()
//    }

}
