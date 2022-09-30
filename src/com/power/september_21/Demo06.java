package com.power.september_21;

import java.util.Arrays;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo06 {

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[k - 1] - nums[0];
        for (int i = 1; i <= nums.length - k; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println((-6 / 5));//-2
//        System.out.println((-6 % 5));//4
//        System.out.println((-6 % 3));//-2
        System.out.println(minimumDifference(new int[]{1,4,7,9}, 2));
    }
}
