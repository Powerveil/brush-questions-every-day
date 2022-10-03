package com.power.september_21;

import java.util.*;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo7 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findEvenNumbers(new int[] {2,2,8,8,2})));
    }

    //1.失败 没有考虑结果中有重复元素(来源于不同下标的元素的可能相同)
//    public static int[] findEvenNumbers(int[] digits) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < digits.length; i++) {
//            for (int j = 0; j < digits.length; j++) {
//                for (int k = 0; k < digits.length; k++) {
//                    if (i == j || j == k || i == k) {
//                        continue;
//                    }
//                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
//                    if (number >= 100 && number % 2 == 0) {
//                        list.add(number);
//                    }
//                }
//            }
//        }
//        int[] results = new int[list.size()];
//        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//            results[i] = list.get(i);
//        }
//
//        return results;
//    }
    //2.使用HashSet去重
//    public int[] findEvenNumbers(int[] digits) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < digits.length; i++) {
//            for (int j = 0; j < digits.length; j++) {
//                for (int k = 0; k < digits.length; k++) {
//                    if (i == j || j == k || i == k) {
//                        continue;
//                    }
//                    int number = digits[i] * 100 + digits[j] * 10 + digits[k] * 1;
//                    if (number >= 100 && number % 2 == 0) {
//                        set.add(number);
//                    }
//                }
//            }
//        }
//        int[] results = new int[set.size()];
//        int w = 0;
//        for (Integer i : set) {
//            results[w++] = i;
//        }
//
//        Arrays.sort(results);
//
//        return results;
//    }


    //3.
//    public int[] findEvenNumbers(int[] digits) {
//        // 统计0 ~ 9各个数字的出现次数
//        int[] count = new int[10];
//        for(int digit: digits){
//            count[digit] ++;
//        }
//
//        // 百位、十位、个位按各自规则不重不漏的进行数字选取
//        // 各个位置选取之后统计结果减一，完成当前遍历后恢复（统计结果再加一）
//        List<Integer> list = new ArrayList<>();
//
//        // 百位按1 ~ 9取存在的数字（保证了顺序且不重复）
//        for(int i = 1; i < 10; i ++){
//            if(count[i] > 0){
//                count[i] --;
//                // 十位取剩余0 ~ 9中存在的数字（保证了顺序且不重复）
//                for(int j = 0; j < 10; j ++){
//                    if(count[j] > 0){
//                        count[j] --;
//                        // 个位取剩余存在的偶数（保证了顺序且不重复）
//                        for(int k = 0; k < 10; k += 2){
//                            if(count[k] > 0){
//                                list.add(i * 100 + j * 10 + k);
//                            }
//                        }
//                        count[j] ++;
//                    }
//                }
//                count[i] ++;
//            }
//        }
//
//        // 将有序的list按顺序转为int[]后返回
//        int size = list.size();
//        int[] ans = new int[size];
//        for(int i = 0; i < size; i ++){
//            ans[i] = list.get(i);
//        }
//        return ans;
//    }
}
