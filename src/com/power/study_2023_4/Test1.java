//package com.power.study_2023_4;
//
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * @author power
// * @Date 2023/4/3 21:20
// */
//public class Test1 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int n = scanner.nextInt();
////        System.out.println("a=" + a);
////        System.out.println("b=" + b);
////        System.out.println("n=" + n);
////        int workDay = a * 5;
////        int weekend = b * 2;
////        int Aweek = workDay + weekend;
////
////        int day = 0;
////        int w = 0;
////
////        day += (n / Aweek) * 7;
////
////        w = n % Aweek;
////        if (w != 0) {
////            if (w < workDay) {
////                day += w / a;
////                if (w % a != 0) {
////                    day++;
////                }
////            } else {
////                day += 5;
////                w -= workDay;
////                day += w / b;
////                if (w % b != 0) {
////                    day++;
////                }
////            }
////        }
////
////        System.out.println(day);
//
//        int day = 0;
//
//        while (n > 0) {
//            day++;
//            if (day % 7 == 6 || day % 7 == 0) {
//                n -= b;
//            } else {
//                n -= a;
//            }
//        }
//        System.out.println(day);
//
//    }
//
//    /**
//     * 题目描述
//     * 本题为填空题，只需要算出结果后，在代码中使用输出语句将所填结果输出即可。
//     * <p>
//     * 小蓝有很多数字卡片，每张卡片上都是数字0到9。
//     * 小蓝准备用这些卡片来拼一些数，他想从1开始拼出正整数，每拼一个，就保存起来，卡片就不能用来拼其它数了。
//     * 小蓝想知道自己能从1拼到多少。
//     * 例如，当小蓝有30张卡片，其中0到9各3张，则小蓝可以拼出1到10,但是拼11时卡片1已经只有一张了，不够拼出11。
//     * 现在小蓝手里有0到9的卡片各2021张，共20210张，请问小蓝可以从1拼到多少?
//     */
//    @Test
//    public void test1() {
//        Scanner scanner = new Scanner(System.in);
////        int num = scanner.nextInt();
//        int[] nums = new int[10];
//        for (int i = 0; i < 10; i++) {
//            nums[i] = 2021;
//        }
//
//        boolean falg = false;
//        for (int i = 1; ; i++) {
//            int temp = i;
//            while (temp != 0) {
//                int t = temp % 10;
//                if (nums[t] <= 0) {
//                    falg = true;
//                    break;
//                }
//                nums[t]--;
//                temp = temp / 10;
//            }
//            if (falg) {
//                break;
//            }
//            System.out.println(i - 1);
//        }
//    }
//
//
//    /**
//     * 小蓝要为一条街的住户制作门牌号。
//     * <p>
//     * 这条街一共有 2020 位住户，门牌号从 1 到 2020 编号。
//     * <p>
//     * 小蓝制作门牌的方法是先制作 0 到 9 这几个数字字符，最后根据需要将字符粘贴到门牌上, 例如门牌 1017 需要依次粘贴字符 1、0、1、7, 即需要 1 个字符 0，2个字符 1，1 个字符 7。
//     * <p>
//     * 请问要制作所有的 1 到 2020 号门牌，总共需要多少个字符 2？
//     */
//    @Test
//    public void test2() {
//        int count = 0;
//        for (int i = 1; i <= 2020; i++) {
//            int temp = i;
//            while (temp > 0) {
//                if (temp % 10 == 2) count++;
//                temp /= 10;
//            }
//        }
//        System.out.println(count);
//    }
//
//
//    /**
//     * 小明对数位中含有 2、0、1、9 的数字很感兴趣，在 1 到 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28个，他们的和是 574，平方和是 14362。
//     * <p>
//     * 注意，平方和是指将每个数分别平方后求和。
//     * <p>
//     * 请问，在 1 到 2019中，所有这样的数的平方和是多少？
//     */
//    @Test
//    public void test3() {
//        long sum = 0;
//        for (long i = 1; i <= 2019; i++) {
//            long temp = i;
//            while (temp > 0) {
//                if (temp % 10 == 0 || temp % 10 == 1 ||
//                        temp % 10 == 2 || temp % 10 == 9
//                ) {
//                    sum += i * i;
//                    break;
//                }
//                temp /= 10;
//            }
//        }
//        System.out.println(sum);
//    }
//
//    @Test
//    public void test4() {
//        int molecular = (int) Math.pow(2, 20) - 1;
//        int denominator = (int) Math.pow(2, 19);
//        System.out.println(molecular + "/" + denominator);
//    }
//
//
//    @Test
//    public void test5() {
//        int number = 2022;
//        int newNumber = 0;
//        int ret = 1;
//        while (number > 0) {
//            newNumber += (number % 10) * ret;
//            ret *= 9;
//            number /= 10;
//        }
//        System.out.println(newNumber);
//    }
//
//
//    @Test
//    public void test6() {
//        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
////        System.out.println(months.length);
////        for (int month : months) {
////            System.out.println(month);
////        }
////        System.out.println(months.length);
//        StringBuilder year = new StringBuilder("2022");
//        int count = 0;
//        for (int month = 0; month < 12; month++) {
//            if (month < 9) {
//                year.append("0");
//            }
//            year.append(month + 1);
////            System.out.println("打印到月份：" + year);
//            for (int i = 1; i <= months[month]; i++) {
//                if (i < 10) {
//                    year.append("0");
//                }
//                year.append("").append(i);
////                System.out.println("打印到日：" + year);
//                if (year.indexOf("123") >= 0) {
//                    count++;
//                }
//                year.delete(6, year.length());
//            }
//            year.delete(4, year.length());
////            System.out.println("回归本心" + year);
//        }
//        System.out.println(count);
////        StringBuilder s = new StringBuilder("123456");
////        System.out.println(s);
////        System.out.println(s.delete(4, s.length()));
//    }
//
//
//    @Test
//    public void test7() {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int n = scanner.nextInt();
//        System.out.println("a=" + a);
//        System.out.println("b=" + b);
//        System.out.println("n=" + n);
//    }
//
//
//    @Test
//    public void test8() {
//        int n = 5;
//        int[] nums = new int[n];
//        for (int i = 1; i <= n; i++) {
//            nums[i - 1] = 2 * (n - i);
//        }
//        System.out.println(Arrays.toString(nums));
//        for (int i = 1; i <= n; i++) {
//            if (i <= n / 2) {
//                nums[i - 1] = 2 * (n - i);
//            } else {
//                nums[i - 1] = 2 * (i - 1);
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//
//        for (int i = 1; i <= n; i++) {
//            nums[i - 1] = 2 * Math.max(n - i, i - 1);
//        }
//        System.out.println(Arrays.toString(nums));
//    }
//
//    @Test
//    public void test() {
//        int[] heights = new int[10];
//        for (int current = 0; current < heights.length; current++) {
//            int height = heights[current] + 1;
//            heights[current] = Math.max(heights[current], height);
//        }
//    }
//
//    @Test
//    public void test9() {
////        System.out.println(gcd(5 , 10));
//        int count = 0;
//        for (int i = 1; i <= 2022; i++) {
//            for (int j = 1; j <= 2022; j++) {
//                if (gcd(i, j) == 1) count++;
//            }
//        }
//        System.out.println(count);
//
//    }
//
//    private int gcd(int a, int b) {
//        if (a % b == 0) return b;
//        else if (b % a == 0) return a;
//        else if (a > b) return gcd(a - b, b);
//        else return gcd(b - a, a);
//    }
//
//}
