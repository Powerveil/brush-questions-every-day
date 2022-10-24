package com.power.test01;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo02 {
//    public static void main(String[] args) {
////        ConcurrentHashMap
//        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
//    }

//    public int findRepeatNumber(int[] nums) {
//        int[] arr = new int[nums.length];
//        for (int num : nums) {
//            arr[num]++;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > 1) return i;
//        }
//        return -1;
//    }

    public static int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            if (arr[num] > 0) return num;
            arr[num]++;
        }
        return -1;
    }


//    public int findRepeatNumber(int[] nums) {
//        int[] arr = new int[nums.length];
//        for (int num : nums) if (arr[num]++ > 0) return num - 1;
//        return -1;
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        ArrayList<String> list = new ArrayList<>();
//
//        StringBuilder sb = new StringBuilder(s);
//        sb.delete()
//
//        if (s.indexOf("\"") == -1) {
//            String[] split = s.split(" ");
//            System.out.println(split.length);
//        } else {
//
//        }
//    }


//    public static void main(String[] args) {
//        String s = "\"dsadsa\"";
//        System.out.println(s.indexOf("\""));
//        System.out.println(s.indexOf("\"",s.indexOf("\"") + 1));
//    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        String[] split = s.split(" ");
//        int year = Integer.parseInt(split[0]);
//        int month = Integer.parseInt(split[1].charAt(0) != '0' ? split[1] : (split[1].charAt(1) + ""));
//        int day = Integer.parseInt(split[2].charAt(0) != '0' ? split[2] : (split[2].charAt(1) + ""));
////        System.out.println("year=" + year);
////        System.out.println("month=" + month);
////        System.out.println("day=" + day);
//        int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31};
//        int sum = 0;
//        for (int i = 0; i < month - 1; i++) {
//            sum += arr[i];
//        }
//        sum += day;
//        if (month > 2 && istt(year)) sum++;
//        System.out.println(sum);
//
//    }
//
//    private static boolean istt(int year) {
//        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

    }
}
