package com.power.september_21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo15 {
//    public static void main(String[] agrs) {
//        Scanner in = new Scanner(System.in);
//
//        String str = in.nextLine();
//
//        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
//                sb.append(str.charAt(i));
//            } else {
//                if (sb.length() != 0) {
//                    priorityQueue.add(sb.toString());
//                    sb = new StringBuilder();
//                }
//            }
//        }
//        priorityQueue.add(sb.toString());
//        System.out.println(priorityQueue.peek());
//    }

    public static int MoreThanHalfNum_Solution (int[] numbers) {
        // write code here
        int mark = numbers[0];
        int count = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (mark == numbers[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                mark = numbers[i];
                count++;
            }
        }

        count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (mark == numbers[i]) {
                count++;
            }
        }
        return count > numbers.length / 2 ? mark : 0;
    }

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[] {1,2,1,2,1,2,1,1}));
    }
}
