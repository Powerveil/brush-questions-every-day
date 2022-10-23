package com.power.test01;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo02 {
    public static void main(String[] args) {
//        ConcurrentHashMap
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

//    public int findRepeatNumber(int[] nums) {
//        int[] arr = new int[nums.length];
//        for (int num : nums) {
//            arr[num]++;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > 1) return i;
//        }
//        return -1;
//    }

    public static int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            if (arr[num] > 0) return num;
            arr[num]++;
        }
        return -1;
    }


//    public int findRepeatNumber(int[] nums) {
//        int[] arr = new int[nums.length];
//        for (int num : nums) if (arr[num]++ > 0) return num - 1;
//        return -1;
//    }
}
