package com.power.test01;

import java.util.Arrays;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo5 {
    public static void main(String[] args) {

        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
//            e.printStackTrace();
            System.out.println("除数不能为0");
        }

        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
            System.out.println("数组访问越界");
        }
//        System.out.println(Arrays.toString(a));

    }


    public int maxmiumScore(int[] cards, int cnt) {
        // 遇事不决，优先排序
        Arrays.sort(cards);
        int n = cards.length;
        int score = 0;
        for (int i = n - 1; i >= n - cnt; i--) {
            score += cards[i];
        }
        // 排序先取最大的cnt个数，如果它们的和是偶数直接输出
        if (score % 2 == 0) {
            return score;
            // 不然就找一个已取的最小的奇数换成剩下未取的最大的偶数，或者找一个已取的最小的偶数换成剩下未取的最大奇数
        } else {
            // 通过测试用例：101 / 104
            // //已取的最小的奇数
            // int idx = n - cnt;
            // int minOdd = 0;
            // while (idx < n) {
            //     if (cards[idx] % 2 == 1) {
            //         minOdd = cards[idx];
            //     }
            //     idx++;
            // }
            // int idx = n - cnt;
            // while (idx >= 1) {
            //     score -= cards[idx];
            //     score += cards[idx - 1];
            //     if (score % 2 == 0) {
            //        return score;
            //     }
            //     idx--;
            // }

            // 先去最大的cnt个数，若sum为偶数，直接返回
            // 若为奇数，则在已选的数字中，和未选择的数字中选择差值最小且奇偶性相反的数字交换
            int min = Integer.MAX_VALUE;
            for (int i = n - cnt; i < n; i++) {
                for (int j = n - cnt - 1; j >= 0; j--) {
                    if (cards[i] % 2 == 0 && cards[j] % 2 != 0) {
                        min = Math.min(min, cards[i] - cards[j]);
                        break;
                    } else if (cards[i] % 2 != 0 && cards[j] % 2 == 0) {
                        min = Math.min(min, cards[i] - cards[j]);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                return 0;
            } else {
                return score - min;
            }
        }
    }
}
