package com.power._2022.study_2022_12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Teee {
//    public static void main(String[] agrs) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String s = scanner.nextLine();
//            boolean[] flag = new boolean[127];
//            StringBuilder result = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                if (!flag[c]) {
//                    result.append(c);
//                    flag[c] = true;
//                }
//            }
//            System.out.println(result.toString());
//        }
//    }

//    public static void main(String[] args) {
//        merge(new int[] {1,2,0,0,0,0},2,new int[] {4,5,6,7},4);
//    }


    public static void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int k = A.length - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (i >= 0) {
            A[k--] = A[i--];
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
        System.out.println(Arrays.toString(A));
    }

//    public int[] smallestK(int[] arr, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return (Integer)o1 - (Integer) o2;
//            }
//        });
//        for (int j : arr) {
//            priorityQueue.offer(j);
//        }
//        int[] ww = new int[k];
//        for (int i = 0; i < k; i++) {
//            ww[i] = priorityQueue.poll();
//        }
//        return ww;
//    }


    public static int[] smallestK(int[] arr, int k) {
        if (k == 0) return arr;
        int[] ww = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)o2 - (Integer) o1;
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ww[i] = priorityQueue.poll();
        }
        return ww;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestK(new int[]{1, 2, 3, 4, 5}, 0)));
    }
}