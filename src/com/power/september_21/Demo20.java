package com.power.september_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo20 {
    public String[] sortPeople(String[] names, int[] heights) {
        int[][] arr = new int[heights.length][2];
        for (int i = 0; i < heights.length; i++) {
            arr[i][0] = heights[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        String[] results = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            results[i] = names[arr[i][1]];
        }

        return results;
    }

    public int StrToInt(String str) {
        if (str.length() == 0) return 0;

        int ww = 1;
        int number = 0;
        char fuhao = '+';
        int t = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            fuhao = str.charAt(0);
            t++;
        }
        for (int i = str.length() - 1; i >= t; i--) {
            char c = str.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                number = 0;
                return 0;
            }
            number += ((c - '0') * ww);
            ww *= 10;
        }
        if (fuhao == '-') {
            number = -number;
        }
        return number;
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line = in.readLine();
//        String[] s = line.split(" ");
//        int w = Integer.parseInt(s[0]), h = Integer.parseInt(s[1]);
//        int res = 0;
//        int w_yu = w % 4, h_yu = h % 4;
//        res = (w - w_yu) * (h - h_yu) / 2;
//        //横向多余
//        res += w_yu * (h - h_yu) / 2;
//        //竖向多余
//        res += h_yu * (w - w_yu) / 2;
//        //  System.out.println(w_yu + ", " + h_yu);
//        //重叠多余
//        if(w_yu == 1 || w_yu == 2) {
//            if(h_yu == 1) {
//                res += 1 * w_yu;
//            }
//            else if(h_yu >= 2) {
//                res += 2 * w_yu;
//            }
//        }
//        else if(w_yu == 3 || w_yu == 4) {
//            if(h_yu <= 2) {
//                res += 2 * h_yu;
//            }
//            else {
//                res += (h_yu - 2) * (w_yu - 2) + 4;
//            }
//        }
//        System.out.println(res);
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        int count = 0;//蛋糕数
//        int[][] arr = new int[a][b];
//
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < b; j++) {
//                arr[i][j] = 1;
//            }
//        }
//
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < b; j++) {
//                if (arr[i][j] == 1) {
//                    count++;
//                    if (i + 2 < a) {
//                        arr[i + 2][j] = 0;
//                    }
//                    if (j + 2 < b) {
//                        arr[i][j + 2] = 0;
//                    }
//                }
//            }
//        }
//        System.out.println(count);
//    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt(), H = sc.nextInt();
        if (W <= 2 && H <= 2) {
            System.out.println(W * H);
            return;
        }
        if (W <= 2) {
            int temp = W;
            W = H;
            H = temp;
        }
        int r = 0, a = W / 2, b = W % 2;
        if (b == 1) a++;
        int len1 = a, len2 = a - 1;
        r += H / 4 * 2 * W;
        if (H % 4 == 1) r += len1;
        if (H % 4 == 2) r += 2 * len1;
        if (H % 4 == 3) r += len1 + W;
        System.out.println(r);
    }
}
