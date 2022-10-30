package com.power.test01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split("-");
        s = split[0];
        String q = split[1];


        s = s.replaceAll("A", "1");
        s = s.replaceAll("J", "11");
        s = s.replaceAll("Q", "12");
        s = s.replaceAll("K", "13");
        s = s.replaceAll("joker", "14");
        s = s.replaceAll("JOKER", "15");

        q = q.replaceAll("A", "1");
        q = q.replaceAll("J", "11");
        q = q.replaceAll("Q", "12");
        q = q.replaceAll("K", "13");
        q = q.replaceAll("joker", "14");
        q = q.replaceAll("JOKER", "15");

    }




    public static void qq(String[] s, String[] q) {
        int[] ints1 = ww1(s);
        int[] ints2 = ww1(q);
        if (ints1[0] >= ints2[0]) {
            if (ints1[0] == ints2[0]) {

            }
        }
    }


    /**
     *
     * @param split
     * @return [0]表示类型 [1]表示最大数
     */
    public static int[] ww1(String[] split) {
//        int count01 = 1;// 连续数的个数
//        int maxCount = count01;
//        int a = Integer.parseInt(split[0]);
//        int maxA = a;
//
//        for (int i = 1; i < split.length; i++) {
//            int b = Integer.parseInt(split[i]);
//            if (a == b) {
//                count01++;
//                if (count01 > maxCount) {
//                    maxCount = count01;
//                    maxA = a;
//                }
//            } else {
//                a = b;
//                count01 = 1;
//            }
//        }

        int maxCount = 1;
        int maxA = 0;
        int[] arr = new int[16];


        for (int i = 0; i < split.length; i++) {
            int index = Integer.parseInt(split[i]);
            arr[index]++;
            if (arr[index] >= maxCount) {
                maxA = index;
                maxCount = arr[index];
            }
        }

        if (maxCount == 1) {
            if (arr[14] != 0) {
                if (arr[15] != 0) {
                    maxA = 15;
                } else {
                    maxA = 14;
                }
            }
        }

        if (maxCount == 4) {
            if ((arr[14] & arr[15]) == 1) maxA = 14;
        }


        return new int[] {maxCount, maxA};
    }


    public int purchasePlans(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) right--;
            else {
                count += (right - left);
                count %= 1000000007;
                left++;
            }
        }
        return count;
    }


    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int mod = 1000000007;
        int left = 0;
        int right = drinks.length - 1;
        int count = 0;
        while (left < staple.length && right >= 0) {
            if (staple[left] + drinks[right] > x) right--;
            else {
                count += (right + 1);
                count %= mod;
                left++;
            }
        }
        return count;
    }
}
