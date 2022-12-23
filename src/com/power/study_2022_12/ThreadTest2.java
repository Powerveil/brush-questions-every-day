package com.power.study_2022_12;

/**
 * @author power
 * @Date 2022/12/23 10:55
 */
public class ThreadTest2 {

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
//            System.out.println(Thread.currentThread().getName() + "|" + i);
            new Thread(ThreadTest2::thead1).start();
            thead3();
        }
    }

    private synchronized static void thead1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "|" + i);
        }
    }

    private synchronized static void thead2() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "|" + i);
        }
    }

    private synchronized static void thead3() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "|" + i);
        }
    }
}
