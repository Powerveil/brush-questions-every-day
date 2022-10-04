package com.power.september_21;

import java.util.*;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo08 {
    public static void main(String[] args) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            System.out.println(entry.getKey() + entry.getValue());
//        }
//        System.out.println((1 ^ 2));// 01  10  010100
//        //                                     000100
//        //                                     010000
//        FindNumsAppearOnce(new int[] {1,2,3,2,3,5,6,5,6,15},new int[1],new int[1]);
//        System.out.println(MoreThanHalfNum_Solution(new int[] {1,2,2,3,3,22,2,2,2,2}));
        System.out.println(Arrays.toString(maxSubsequence(new int[]{-4, -2, -6, 4, 6, 3, 4}, 6)));
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int res = 0;
        for (int a : array) res ^= a;// 1111  0001
        res &= (-res);
        for (int a : array) {
            if ((res & a) != 0) num1[0] ^= a;
            else num2[0] ^= a;
        }
    }


    public static int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > array.length / 2) {
                return (int) entry.getKey();
            }
        }
        return -1;
    }

//    public static int[] maxSubsequence(int[] nums, int k) {
//        int len = nums.length;
//        // idxMap：辅助数组，用来存储数值和索引
//        int idxMap[][] = new int[len][2];
//        for(int idx = 0; idx < len; idx++){
//            idxMap[idx][1] = nums[idx];
//            idxMap[idx][0] = idx;
//        }
//        // 按照数值nums[idx]从大到小排序
//        Arrays.sort(idxMap, (a, b) -> b[1] - a[1]);
//        // 按照索引idx从小到大进行排列
//        Arrays.sort(idxMap, 0, k, (a, b) -> a[0] - b[0]);
//
//        // 复制结果
//        int[] res = new int[k];
//        for(int idx = 0; idx < k; idx++){
//            res[idx] = idxMap[idx][1];
//        }
//
//        return res;
//    }

    public static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, (o1, o2) -> {
            return o2[1] - o1[1];
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{i, nums[i]});
        }

        PriorityQueue<int[]> pqRe = new PriorityQueue<int[]>(k, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int index = k;
        while (index > 0) {
            pqRe.offer(pq.poll());
            index--;
        }

        int[] result = new int[k];
        while (index < k) {
            result[index++] = pqRe.poll()[1];
        }
        return result;
    }
}
