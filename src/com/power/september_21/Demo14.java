package com.power.september_21;

import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo14 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//
//        if (n > 1) {
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = in.nextInt();
//            }
//
//            int count = 1;
//            int i = 1;
//            while (arr[i-1] == arr[i]) i++;
//            int flag = arr[i - 1] < arr[i] ? 1 : -1;
//
//            for (; i < arr.length; i++) {
//                if (flag == 1) {
//                    while (i < arr.length && arr[i - 1] <= arr[i]) i++;
//                    if (i < arr.length) {
//                        count++;
//                        flag = -1;
//                    }
//                } else {
//                    while (i < arr.length && arr[i - 1] >= arr[i]) i++;
//                    if (i < arr.length) {
//                        count++;
//                        flag = 1;
//                    }
//                }
//                i++;
//                if (i < arr.length) {
//                    flag = arr[0] < arr[1] ? 1 : -1;
//                }
//            }
//
//            System.out.println(count);
//        } else {
//            System.out.println(1);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//
//        int i = 1;
//        while (i < arr.length && arr[i - 1] == arr[i]) i++;
//
//        if (i < arr.length) {
//            int flag = arr[i - 1] < arr[i] ? 1 : -1;
//            int max = 0;
//            int min = 0;
//            int count = 0;
//            if (flag == 1) {
//                max = arr[i++];
//                count++;
//            } else {
//                min = arr[i++];
//            }
//            for (; i < n; i++) {
//                if (flag == 1) {
//                    if (arr[i] < max) {
//                        flag = -1;
//                        min = arr[i];
//                        count++;
//                    } else {
//                        max = arr[i];
//                    }
//                } else {
//                    if (arr[i] > min) {
//                        flag = 1;
//                        max = arr[i];// 1 2 3 | 2 2 1 | 2 1 | 2 1 |
//                    } else {
//                        min = arr[i];
//                    }
//                }
//            }
//            System.out.println(count);
//        } else {
//            System.out.println(1);
//        }
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        StringBuilder sb = new StringBuilder();
//        String[] split = s.split(" ");
//        for (int i = split.length - 1; i >= 0; i--) {
//            sb.append(split[i] + " ");
//        }
//        System.out.println(sb.toString());
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int index = 0;
        int count = 0;
        int flag = 1;
        int i = 1;
        while (i < n && arr[i - 1] == arr[i]) i++;

    }
}
