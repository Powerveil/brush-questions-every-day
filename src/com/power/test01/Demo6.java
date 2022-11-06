package com.power.test01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo6 {
    public int[] smallestK(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }

//    public static int halfQuestions(int[] questions) {
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        int[] arr = new int[100001];
//        for (int a : questions) {
//            arr[a]++;
//            hashMap.put(a, arr[a]);
//        }
//
//        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
//        for (Map.Entry a : entries) {
//            list.add((Integer) a.getValue());
//        }
//
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        int len = questions.length / 2;
//        if (len <= list.get(0)) {
//            return 1;
//        }
//        int count = 0;
//        for (Integer a : list) {
//            count++;
//            if (len > a) {
//                len -= a;
//            } else {
//                break;
//            }
//        }
//        return count;
//    }

//    public int halfQuestions(int[] questions) {
//        // 初始哈希表
//        int[] nums = new int[1001];
//        for (int x:questions) nums[x]++;
//        // 数量和
//        int sum = 0;
//        // 知识点
//        int count = 0;
//        // 排序
//        Arrays.sort(nums);
//        for (int i = nums.length-1; i >= 0; i--) {
//            sum += nums[i];
//            count++;
//            // 当此时的数量和超过问题数/2
//            if (sum >= questions.length/2) break;
//        }
//        return count;
//    }

//    public static int halfQuestions(int[] questions) {
//        int[] arr = new int[1001];
//        for (int a : questions) arr[a]++;
//        Arrays.sort(arr);
//        for (int i = arr.length - 1; i >= 0; i--) {
//
//        }
//    }

    public static void main(String[] args) {
//        System.out.println(halfQuestions(new int[] {2,1,6,2}));
//        System.out.println(halfQuestions(new int[] {13,8,3,7,5,6,11,12,3,6,6,11}));
//        System.out.println(halfQuestions(new int[] {1,5,1,3,4,5,2,5,3,3,8,6}));
//        System.out.println(halfQuestions(new int[] {1,5,1,3,4,5,2,5,3,3,8,6}));
//        System.out.println(halfQuestions(new int[] {1,1}));
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//
//        queue.add(6);
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
//
//        System.out.println(queue);
        String s = "123456";
        System.out.println(s.indexOf("1"));
        System.out.println(s.substring(0, s.indexOf("2")));

    }

}
