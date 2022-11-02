package com.power.test01;

import java.util.Arrays;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo5 {
    public static void main(String[] args) {

        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
//            e.printStackTrace();
            System.out.println("除数不能为0");
        }

        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
            System.out.println("数组访问越界");
        }
        System.out.println(Arrays.toString(a));

    }
}
