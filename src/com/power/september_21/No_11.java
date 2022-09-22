package com.power.september_21;

import java.util.Scanner;

public class No_11 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        int max = 0;
        int sum = 0;
        int x = 0, y = 0;
        // TODO Auto-generated method stub
        Scanner read = new Scanner(System.in);
        System.out.println("请输入数组内数字个数：");
        int n = read.nextInt();
        System.out.println("请输入" + n + "个数并用空格隔开");
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toString();
        String[] arr = str.split(" ");
        int[] a = new int[arr.length];
        for (i = 0; i < a.length; i++)
            a[i] = Integer.parseInt(arr[i]);
        for (i = 0; i < a.length - 1; i++) {
            max = sum = a[i];
            for (int j = i + 1; j < a.length; j++) {
                sum += a[j];
                if (sum >= max) {
                    max = sum;
                    x = i;
                    y = j;
                }

            }
        }
        if (i == 0)
            max = sum;
        else if (max < sum)
            max = sum;
        System.out.println("这个数组中最大子数组的和是：" + max);
        System.out.println("最大子数组开始的下标为：" + x);
        System.out.println("最大子数组结束的下标为：" + y);

    }
}