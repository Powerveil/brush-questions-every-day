package com.power.study_2022_12;

import java.util.HashMap;

/**
 * @author power
 * @Date 2022/12/16 18:06
 */
public class Demo05 {
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
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
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
        while(left <= right) {
            int mid = left + (right - left >> 1);
            if(mid == nums[mid]) {
                left = mid + 1; // 左边全部符合条件 | 最后(left == right)如果相等说明mid+1位置空缺
            } else {
                right = mid - 1; // 右边全部符合条件 | 最后(left == right)如果相等说明left位置空缺 直接退出循环即可
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        System.out.println((-1 >> 1)); // -1
//        System.out.println((-1 >>> 1)); // 2147483647
        System.out.println(aa(1,7));

    }

    private static int aa(int left, int right) {
//        int k = left + (right - left) / 2;
        return left + (right - left >> 1);
    }

}
