package com.power.study_2022_12.test;

@SuppressWarnings("all")

public class Demo {
//    public static void main(String[] args) {
//        Thread t = new Thread(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                System.out.println("hello power!");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                     e.printStackTrace();
//                }
//            }
//            System.out.println("t 线程执行完了");
//        });
//        t.start();
//        t.interrupt();
//        System.out.println("设置让 t 线程结束!");
//    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + "");
                System.out.println("hello power!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        System.out.println("main 线程 join 之前");
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main 线程 join 之后");
        System.out.println(Thread.currentThread().getName() + "");

    }
}