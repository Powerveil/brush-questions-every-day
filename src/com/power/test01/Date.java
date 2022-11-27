package com.power.test01;

import java.util.Scanner;

public class Date {
    public static void main(String[] args) {
        //先输入是几行
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());

        //开始输入每一行的数据
        int b = 0;
        String[] s = new String[a];
        String s1;
        int[] a1 = new int[5];
        for (int i = 0; i < s.length; i++) {
            s1 = sc.nextLine();
            s[i] = s1;
        }

        //记录数组中重复的数据坐标
        for (int i = 0; i < s.length; i++) {
            int q = 0;
            for (int j = 0; j < s.length; j++) {
                if (q + 1 <= s.length - 1) {
                    if (s[i].equals(s[q + 1])) {
                        b += 1;
                        a1[i] = q + 1;
                        q++;
                    }
                }
            }
        }

        //新数组赋值
        String[] s2 = new String[s.length - b];
        for (int i = 0; i < s2.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (i != a1[i]) {
                    s2[i] = s[j];
                }
            }
        }

        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }
    }
}