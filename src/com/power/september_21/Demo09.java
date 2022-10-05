package com.power.september_21;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo09 {
//    public static int minimumCost(int[] cost) {
//        Integer[] arr = new Integer[cost.length];
//        for (int i = 0; i < cost.length; i++) {
//            arr[i] = cost[i];
//        }
////        Arrays.sort(arr, new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return o2 - o1;
////            }
////        });
//        Arrays.sort(arr, (a,b) -> {return b - a;});
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if ((i + 1) % 3 == 0) {
//                continue;
//            }
//            sum += arr[i];
//        }
//        return sum;
//    }

//    public static int minimumCost(int[] cost) {
//        Arrays.sort(cost);
//        int length = cost.length;
//        int index = length - 1;
//        int sum = 0;
//        while (index >= 2) {
//            sum += cost[index] + cost[index - 1];
//            index -= 3;
//        }
//        while (index >= 0) {
//            sum += cost[index--];
//        }
//        return sum;
//    }


    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int len = cost.length;
        for (int t = 0; t < len; t++) {
            if ((t + 1) % 3 == 0) {
                continue;
            }
            sum += cost[len - t - 1];
        }
        return sum;
    }

    public int countElements1(int[] nums) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length - 1]) return 0;
        int count = 2;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] != nums[left + 1]) break;
            count++;
            left++;
        }
        while (left < right) {
            if (nums[right] != nums[right - 1]) break;
            count++;
            right--;
        }
        return nums.length - count;
    }

    public int countElements2(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        int count = 0;
        for (int num : nums) {
            if (min < num && num < max) {
                count++;
            }
        }
        return count;
    }

    public int countElements3(int[] nums) {
        int max=nums[0],min=max,ans=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        for(int i=0;i<nums.length;i++){if(nums[i]>min&&nums[i]<max){ans++;}}
        return ans;
    }

    public int findFinalValue1(int[] nums, int original) {
        for (int num : nums) {
            if (num == original) {
                return findFinalValue1(nums, original * 2);
            }
        }
        return original;
    }

    public int findFinalValue2(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == original) original *= 2;
        }
        return original;
    }

    public int findFinalValue3(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(original)) original *= 2;
        return original;
    }

    public static void main(String[] args) {
        System.out.println(minimumCost(new int[] {5,5}));
    }
}
