package com.power.test01;

import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo07 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        while (n--> 0) {
////            System.out.println("aaa");
//            int len = scanner.nextInt();
//            int k = scanner.nextInt();
//            int[] arr = new int[len * 2];
//            for (int i = 0; i < len; i++) {
//                arr[i] = scanner.nextInt();
//            }
//            for (int i = len; i < arr.length; i++) {
//                arr[i] = scanner.nextInt();
//            }
////            System.out.println(java.util.Arrays.toString(arr));
//
//
//            while (k--> 0) {
//                ww(arr);
//            }
//            System.out.println(java.util.Arrays.toString(arr));

//            new File("dsa").de
        String s = "x,yy,123";
        Scanner scanner = new Scanner(s);
        while (scanner.hasNext()) {
            System.out.println(scanner.next() + " ");
        }

//        InputStream
//        OutputStream

    }

    private static void ww(int[] arr) {
        int[] numbers = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i += 2) {
            numbers[i] = arr[j++];
        }
        for (int i = 1; i < arr.length; i += 2) {
            numbers[i] = arr[j++];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numbers[i];
        }
    }
}
