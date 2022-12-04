package com.power.september_21;

import java.util.ArrayList;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo05 {

    public static int minNumberInRotateArray(ArrayList<Integer> array) {
        if (array == null && array.size() == 0) {
            return 0;
        }

        int left = 0;
        int right = array.size() - 1;
        int mid = 0;
        while (array.get(left) >= array.get(right)) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            if (array.get(mid) == array.get(left) && array.get(mid) == array.get(right)) {
                int result = array.get(left);
                for (int i = left + 1; i < right; i++) {
                    result = result < array.get(i) ? result : array.get(i);
                }

                return result;
            }

            mid = left + ((right - left) >> 1);
            if (array.get(mid) >= array.get(left)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return array.get(mid);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] arr = {3, 4, 5, 1, 2};

        for (int i : arr) {
            arrayList.add(i);
        }
        System.out.println(minNumberInRotateArray(arrayList));
//        System.out.println(java.util.Arrays.toString(java.util.Arrays.asList(new int[])));
//        java.util.Arrays.asList(new int[] {12,2,3,4});
    }
}
