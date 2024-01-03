package com.power.test01;

//import com.sun.corba.se.impl.encoding.CDROutputObject;

//import java.util.*;
import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo11 {
//    public static void main(String[] args) {
//        int count = 0;
//        for (int i = 1950; i < 2022; i++) {
//            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
//                count++;
//            }
//        }
//        count += ((2022-1949 - 1) * 365);
//        count ++;// 2022 1.1
//        count += (31 + 30 + 31);
//        count -= 2;
//        System.out.println(count);
//    }

//    public static void main(String[] args) {
//        System.out.println(ww(100));
//        System.out.println(qq(ww(100)));
////        int temp = 4;
////        for (int i = 10; i <= 8518; i++) {
////            int a = ww(i);
////            if (a % i == 0) {
////                temp = qq(a);
////                System.out.println(a);
////                System.out.println(temp);
////                break;
////            }
////        }
////        System.out.println(temp);
//    }


//    /**
//     * 计算以这个数为16进制的数
//     * @return 返回一个10进制数
//     */
//    private static int ww(int number) {
//        int ret = 1;
//        int nn = 0;
//        while (number != 0) {
//            nn += ((number % 10) * ret);
//            number /= 10;
//            ret *= 16;
//        }
//        return nn;
//    }
//
//
//    private static int qq(int number) {
//        if (number == 0) return 0;
//        return qq(number / 10) + 1;
//    }

//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        int count = 0;
//        for (int i = 0; i < 2022; i++) {
//            if (isPrime(i)) {
//                System.out.print(i + " ");
//                count++;
//                if (count % 10 == 0) {
//                    System.out.println();
//                }
//                list.add(i);
//            }
//        }
//
////        for (int i = 0; i < list.size(); i++) {
////            for (int j = i + 1; j < list.size(); j++) {
////                if (list.get(i) + list.get(j) > 2022) break;
////                for (int k = j + 1; k < list.size(); k++) {
////                    if (list.get(i) + list.get(j) + list.get(k) > 2022) break;
////                    for (int w = k + 1; w < list.size(); w++) {
////                        if (list.get(i) + list.get(j) + list.get(k) + list.get(w) > 2022) break;
////                        for (int q = w + 1; q < list.size(); q++) {
////                            int temp = list.get(i) + list.get(j) + list.get(k) + list.get(w) + list.get(q);
////                            if (temp == 2022) {
//////                                System.out.println("hello");
////                                count++;
////                            } else if (temp > 2022) {
////                                break;
////                            }
////                        }
////                    }
////                }
////            }
////        }
////        System.out.println(count);
//    }

//    private static boolean isPrime(int number) {
//        if (number < 2) return false;
//        for (int i = 2; i <= Math.sqrt(number); i++) {
//            if (number % i == 0) return false;
//        }
//        return true;
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        double t = scanner.nextDouble();
//        double c = scanner.nextDouble();
//        double s = scanner.nextDouble();
//
//
//        double v = c / t;
//
//        System.out.println((long) ((s - c) / v));
//
//    }


//    public static void main(String[] args) {
////        HashSet<String> hashSet = new HashSet<>();
////        List<String> list = new ArrayList<>();
////        Scanner scanner = new Scanner(System.in);
////        int len = Integer.parseInt(scanner.nextLine());
////        for (int i = 0; i < 5; i++) {
////            String s = scanner.nextLine();
//////            System.out.println(s);
////            if (!hashSet.contains(s)) {
////                hashSet.add(s);
////                list.add(s);
////            }
////        }
//////        System.out.println("+===================================");
////        for (String s : list) {
////            System.out.println(s);
////        }
//////        System.out.println("+===================================");
//
//
//        Scanner scanner = new Scanner(System.in);
////        int len = Integer.parseInt(scanner.nextLine());
//        int len = scanner.nextInt();
//        String[] arr = new String[len];
//        for (int i = 0; i < 5; i++) {
//            arr[i] = scanner.nextLine();
//        }
//        System.out.println("=============");
//        for (String s : arr) {
//            System.out.println(s);
//        }
//        System.out.println("=============");
//
//
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int len = scanner.nextInt();
//        int[] arr = new int[len];
//
//        for (int i = 0; i < len; i++) {
//            arr[i] = scanner.nextInt();
//        }
//
//        System.out.println(ww(arr));
//    }
//
//    private static int ww(int[] arr) {
////        int count = 0;
//        boolean flag = false;
//        int pathLength = 0;
//        for (int i = 0; i < arr.length; i++) {
//            flag = true;
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    pathLength += arr[j];
//                    flag = false;
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j + 1] = temp;
////                    count++;
//                }
//            }
//            if (flag) break;
//        }
//        System.out.println(java.util.Arrays.toString(arr));
////        System.out.println(llll);
////        return count;
//        return pathLength;
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        StringBuilder stringBuilder = new StringBuilder();
//
////        System.out.println(str);
////        System.out.println(ww(str));
////        System.out.println(str.substring(0));
////        System.out.println(str.substring(1));
////        System.out.println(str.substring(2));
//        int i = 0;
//        for (; i < str.length(); i++) {
//            if (ww(str.substring(i))) break;
//        }
//
//        stringBuilder.append(str.substring(0,i));
//
//
//        str = str + stringBuilder.reverse().toString();
////        System.out.println("=================");
//        System.out.println(str);
//        //lanqiaoaiqnal
//        //lanqiaoaiqnal
//    }
//
//    private static boolean ww(String str) {
//        int left = 0;
//        int right = str.length() - 1;
//        while (left < right) {
//            if (str.charAt(left) != str.charAt(right)) return false;
//            left++;
//            right--;
//        }
//        return true;
//    }
}
