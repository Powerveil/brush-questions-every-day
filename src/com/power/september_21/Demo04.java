package com.power.september_21;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 崔帅
 * @version 1.0
 */

class MyThreadPool {
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }

    public MyThreadPool(int m) {
        // 在构造方法中，创建出 M 个线程，负责完成工作
        for (int i = 0; i < m; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }
}

public class Demo04 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool poll = new MyThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int taskId = i;
            poll.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行当前任务：" + taskId + "当前线程：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
