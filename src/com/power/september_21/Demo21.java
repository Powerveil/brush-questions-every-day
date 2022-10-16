package com.power.september_21;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo21 {
//    public static void main(String[] args) {
//        for (char i = 'a'; i <= 'z'; i++) {
//            switch (i) {
//                case 'a':
//                case 'e':
//                case 'i':
//                case 'o':
//                case 'u':
//                    System.out.println(i + ":元音字母");break;
//                case 'y':
//                case 'w':
//                    System.out.println(i + ":有时为元音字母");break;
//                default:
//                    System.out.println(i + ":辅音字母");
//            }
//        }
//    }

//    public static void main(String[] agrs) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int a = 0;
//        int b = 1;
//        int c = 0;
//        while (b < n) {
//            c = b;
//            b = a + b;
//            a = c;
//        }
////         System.out.println(a);
////         System.out.println(b);
//
////         int count = Math.abs(a - n) < Math.abs(b - n) ? Math.abs(a - n) : Math.abs(b - n);
//        int count = Math.min(n - a, b - n);
//        System.out.println(count);
//    }


    public static boolean chkParenthesis(String A, int n) {
        if ((n & 1) == 1) return false;
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (!Islegal(c)) return false;
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            char last = stack.pop();
            if (!((last == '{' && c == '}') || (last == '[' && c == ']') || (last == '(' && c == ')'))) return false;
        }
        return stack.isEmpty();
    }

    private static boolean Islegal(char c) {
        return c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')';
    }

    public static void main(String[] args) {
//        System.out.println(chkParenthesis("{}a{}{}", 7));
        System.out.println(chkParenthesis("(()())", 6));
    }


    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int mod = 1000000007;
        int sl = 0, sd = drinks.length - 1, ans = 0;
        while (sl < staple.length && sd >= 0) {
            int sum = staple[sl] + drinks[sd];
            if (sum <= x) {
                ans += sd + 1;
                ans %= mod;
                sl++;
            } else {
                sd--;
            }
        }
        return ans %= mod;
    }
}
