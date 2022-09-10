package com.power.september_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class No_10 {
//    //微信红包1
//    //使用HashMap
//    public int getValue(int[] gifts, int n) {
//        // write code here
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            hashMap.put(gifts[i], hashMap.getOrDefault(gifts[i],0) + 1);
//            if (hashMap.get(gifts[i]) > n / 2) {
//                return gifts[i];
//            }
//        }
//        return 0;
//    }

//    //微信红包2
//    //使用计数
//    public int getValue(int[] gifts, int n) {
//        // write code here
//        int[] hash = new int[100001];
//        for (int i = 0; i < n; i++) {
//            hash[gifts[i]]++;
//            if (hash[gifts[i]] > n / 2) {
//                return gifts[i];
//            }
//        }
//        return 0;
//    }

    //计算字符串的编辑距离
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //动态规划
        //定义f[i][j]为字符串a前i个字符到字符串b前j个字符的最短编辑距离
        //初始状态f[0][0] = 0 f[0][j] = f[0][j - 1] + 1 f[i][0] = f[i - 1][0] + 1
        //从a中删除相当于在b中插入一个字符，这是等价的
        //状态转移方程
        //情况1：a[i] == b[j] f[i][j] = f[i-1][j-1]
        //情况2：a[i] != b[j] f[i][j] = min(f[i-1][j] + 1, f[i][j-1] + 1, f[i-1][j-1] + 1)
        String a = sc.nextLine();
        String b = sc.nextLine();
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int n = as.length;
        int m = bs.length;

        int[][] f = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            f[i][0] = f[i - 1][0] + 1;
        }
        for (int j = 1; j <= m; j++) {
            f[0][j] = f[0][j - 1] + 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (as[i - 1] == bs[j - 1]) {
                    f[i][j] = f[i - 1][j - 1];
                }
                else {
                    int tmp = f[i - 1][j] < f[i][j - 1] ? f[i - 1][j] + 1 : f[i][j - 1] + 1;
                    f[i][j] = f[i - 1][j - 1] + 1 < tmp ? f[i - 1][j - 1] + 1 : tmp;
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
