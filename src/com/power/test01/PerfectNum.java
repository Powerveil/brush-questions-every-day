package com.power.test01;

import java.util.Random;
import java.util.Scanner;

public class PerfectNum {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int a = 0;
//        for (int i = 1; i <= n; i++) {
//            int j = 1;
//            int sum = 0;
//            while (j < i) {
//                if (i % j == 0) {
//                    sum += j;
//                }
//                j++;
//            }
//            if (i == sum) {
//                a += 1;
//            }
//        }
//        System.out.println(a);



        System.out.println("张三".length());
        String s = "aa";
        s = "aaaaaa";
//        StringBuilder


        Random random = new Random(10);
        Random random2 = new Random(10);
        System.out.print(random.nextInt(5));
        System.out.print(random.nextInt(5));
        System.out.print(random.nextInt(5));
        System.out.print(random.nextInt(5));
        System.out.println(random.nextInt(5));
        System.out.println("===============================");
        System.out.print(random2.nextInt(5));
        System.out.print(random2.nextInt(5));
        System.out.print(random2.nextInt(5));
        System.out.print(random2.nextInt(5));
        System.out.println(random2.nextInt(5));
//        Runtime
        String s1 = (Double.valueOf("31.145")).toString();
        System.out.println(s1);

    }
}