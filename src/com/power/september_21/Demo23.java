package com.power.september_21;

import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo23 {
//    public static void main(String[] args) {
//        //* 1 1 1 1
//        //1 2 3 * *
//        //1 * * * *
//        //1 * * * *
//        //
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//
//        int[][] arr = new int[n][m];
//        for (int i = 1; i < n; i++) arr[i][0] = 1;
//        for (int i = 1; i < m; i++) arr[0][i] = 1;
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
//            }
//        }
//
//        System.out.println(arr[n - 1][m - 1]);
//
//    }



//    public static void main(String[] agrs) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt() + 1;
//        int m = scanner.nextInt() + 1;
//
//        int[][] arr = new int[n][m];
//        for (int i = 1; i < n; i++) arr[i][0] = 1;
//        for (int i = 1; i < m; i++) arr[0][i] = 1;
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
//            }
//        }
//
//        System.out.println(arr[n - 1][m - 1]);
//    }


    public static void main(String[] args) {
        //设计一个全排列
        //设计A和C
        char[] chars = {'1','2','3','4'};

        int len = ww(chars.length);





    }


    private static int ww(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) count *= i;
        return count;
    }
}
