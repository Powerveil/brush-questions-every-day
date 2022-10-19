package com.power.september_21;

import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo24 {
//    public static void main(String[] args) {
//        String s = "Hello World!";
//    }

    public boolean checkWon(int[][] board) {
        // write code here
        for (int i = 0; i < board.length; i++) {
            int j = 1;
            for (; j < board[i].length; j++) {
                if (board[i][j] != board[i][j-1]) break;
            }
            if (j == board[i].length && board[i][j-1] == 1) return true;
        }

        for (int i = 0; i < board[0].length; i++) {
            int j = 1;
            for (; j < board.length; j++) {
                if (board[i][j] != board[i][j-1]) break;
            }
            if (j == board.length && board[i][j-1] == 1) return true;
        }

        if (board[0].length != board.length) return false;

        for (int i = 1; i < board.length; i++) {
            if (board[i][i] != board[i-1][i-1]) return false;
        }
        return board[0][0] == 1;
    }


    public static void main(String[] agrs) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int score = 0;

        //密码长度
        if (str.length() <= 4) score += 5;
        else if (str.length() <= 7) score += 10;
        else score += 25;
        //字母
        boolean flag = str.equals(str.toLowerCase()) || str.equals(str.toUpperCase());
        try {
            Integer a = Integer.parseInt(str);
        } catch(Exception e) {
            if (flag) score += 10;
            else score += 20;
        }

        //字母数量
        int count1 = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) count1++;
        }


        //数字
        int count2 = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) count2++;
        }
        if (count2 == 0);
        else if (count2 == 1) score += 10;
        else score += 20;

        //符号
        int count = str.length() - (count2 + count1);
        if (count == 0);
        else if (count == 1) score += 10;
        else score += 25;


        //奖励
        int temp = 0;
        if (count1 != 0 && count2 != 0) {
            temp = 2;
            if (count != 0) {
                temp = 3;
                if (count1 != 1 && !flag) {
                    temp = 5;
                }
            }
        }
        score += temp;

        if (score >= 90) {
            System.out.println("VERY_SECURE");
        } else if (score >= 80) {
            System.out.println("SECURE");
        } else if (score >= 70) {
            System.out.println("VERY_STRONG");
        } else if (score >= 60) {
            System.out.println("STRONG");
        } else if (score >= 50) {
            System.out.println("AVERAGE");
        } else if (score >= 25) {
            System.out.println("WEAK");
        } else if (score >= 0) {
            System.out.println("VERY_WEAK");
        }





//        System.out.println(score);
    }

//    public static void main(String[] args) {
////        System.out.println("1245aadsA".toUpperCase());
////        System.out.println("1245aadsA".toLowerCase());
//
////        try {
////            int i = Integer.parseInt("454dsad");
////        } catch (NumberFormatException e) {
//////            e.printStackTrace();
////        }
//    }
}
