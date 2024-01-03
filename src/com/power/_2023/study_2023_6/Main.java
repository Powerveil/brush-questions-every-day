package com.power._2023.study_2023_6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Powerveil
 * @Date 2023/6/7 23:34
 */
public class Main {
//    static int[] a = new int[26];

    // 1.字符统计
    //给定一个只包含大写字母的字符串 S SS, 请你输出其中出现次数最多的字符。
    //
    //如果有多个字母均出现了最多次, 按字母表顺序依次输出所有这些字母。
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        for (int i = 0; i < s.length(); i++) {
//            a[s.charAt(i) - 'A']++;
//        }
//        int max = 0;
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 26; i++) {
//            if (a[i] > max) {
//                list.clear();
//                max = a[i];
//                list.add(i);
//            } else if (a[i] == max) list.add(i);
//        }
//        for (int i : list) {
//            System.out.print((char) (i + 'A'));
//        }
//    }

//小蓝老师教的编程课有
    // 名学生, 编号依次是
    // 。第
    // 号学生这学期 刷题的数量是
    //。
    // 对于每一名学生, 请你计算他至少还要再刷多少道题, 才能使得全班刷题 比他多的学生数不超过刷题比他少的学生数。
    //
    //


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        long k = sc.nextLong();
//        long l = 1, r = (long) 9e18;
//        while (l < r) {
//            long mid = l + (r - l) / 2;
//            if (query(mid) >= k) r = mid;
//            else l = mid + 1;
//        }
//        long x = query(r);
//        System.out.println(x == k ? r : -1);
//    }
//
//    static long query(long x) {
//        long ans = 0;
//        while (x > 0) {
//            ans += x / 5;
//            x /= 5;
//        }
//        return ans;
//    }


//    static int N = 200010;
//    static int[] a = new int[N], cnt = new int[N];
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//
//    public static void main(String[] args) throws IOException {
//        int n=Integer.parseInt(br.readLine());
//        String[] s = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(s[i]);
//            cnt[a[i]]++;
//        }
//        for (int i = 1; i <= 100000; ++i) {
//            cnt[i] += cnt[i - 1];
//        }
//        for (int i = 0; i < n; ++i) {
//            if (cnt[100000] - cnt[a[i]] <=(a[i] == 0 ? 0 : cnt[a[i] - 1])) {
//                out.print(0 + " ");
//                continue;
//            }
//            int l = a[i] + 1, r = 100000;
//            while (l < r) {
//                int mid = l + r >> 1;
//                if (cnt[100000] - cnt[mid] <= cnt[mid - 1] - 1) r = mid;
//                else l = mid + 1;
//            }
//            out.print((r - a[i]) + " ");
//        }
//        out.flush();
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            int less = 0, more = 0;
//            for (int j = 0; j < n; j++) {
//                if (a[j] > a[i]) {
//                    more++;
//                } else if (a[j] < a[i]) {
//                    less++;
//                }
//            }
//            int diff = more - less;
//            if (diff >= 0) {
//                System.out.print(diff + " ");
//            } else {
//                System.out.print(0 + " ");
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
    }
}
