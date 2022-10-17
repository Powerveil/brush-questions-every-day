package com.power.september_21;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo22 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        String[] strs = new String[n];
//        String[] strs1 = new String[n];
//        String[] strs2 = new String[n];
//        for (int i = 0; i < n; i++) {
//            strs[i] = scanner.nextLine();
//            strs1[i] = strs[i];
//            strs2[i] = strs[i];
//        }
//
////        System.out.println(Arrays.toString(strs));
//
//        int flag1 = 0;//0为none 1为按字典序排序
//        int flag2 = 0;//0为none 1为按长度排序
//        Arrays.sort(strs1, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//
//        Arrays.sort(strs2, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//
//        int i = 0;
//        for (; i < n; i++) {
//            if (!strs1[i].equals(strs[i])) break;
//        }
//        if (!(i < n)) {
//            flag1 = 1;
//        }
//        i = 0;
//
//
//        for (; i < n; i++) {
//            if (!strs2[i].equals(strs[i])) break;
//        }
//        if (!(i < n)) {
//            flag2 = 1;
//        }
//
//
//        if (flag1 + flag2 == 0) {
//            System.out.println("none");
//        } else if (flag1 + flag2 == 2) {
//            System.out.println("both");
//        } else if (flag1 == 1) {
//            System.out.println("lexicographically");
//        } else {
//            System.out.println("lengths");
//        }
//
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int x = a;
        int y = b;
        int c = 0;
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        while (x % y != 0) {
            c = y;
            y = x % y;
            x = c;
        }
        System.out.println("y=" + y);
        System.out.println((a * b) / y);
    }
}
