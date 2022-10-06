package com.power.september_21;

import java.util.Arrays;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo10 {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        arr[0] = num % 10;
        arr[1] = num / 10 % 10;
        arr[2] = num / 100 % 10;
        arr[3] = num / 1000;
        Arrays.sort(arr);
        return (arr[0] + arr[1]) * 10 + arr[2] + arr[3];
    }
}
