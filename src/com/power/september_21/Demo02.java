package com.power.september_21;

import java.util.PriorityQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author 崔帅
 * @version 1.0
 */

class MyTask implements Comparable<MyTask> {
    // 要执行的任务
    private Runnable runnable;
    // 什么时间来执行任务，（是一个时间戳）
    private long time;

    public MyTask(Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + time;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
//        return (int)(time - ((MyTask)o).getTime());
        return (int)(this.time - o.time);
    }

}

class MyTimer {
    private BlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    private Object locker = new Object();

    public MyTimer() {
        //创建一个扫描线程
        Thread t = new Thread(() -> {
            System.out.println("第一次");
            while (true) {
                //取出队列元素
                try {
                    synchronized (locker) {
                        //                    if (queue.isEmpty()) {
//                        continue;
//                    }
                        MyTask task = queue.take();
                        System.out.println(task);
//                        System.out.println("task.getTime()=" + task.getTime());
                        // 假设当前时间是 2:30，任务设定的时间是 2:30，显然就执行任务了
                        // 假设当前时间是 2:30，任务设定的时间是 2:29，也是到点了，也要执行任务
                        long curTime = System.currentTimeMillis();
//                        System.out.println("curTime=" + curTime);
                        if (curTime >= task.getTime()) {
                            // 到点了，该执行任务！！
                            task.getRunnable().run();
                        } else {
                            // 还没到点
                            queue.put(task);
                            // 没到点，就等待
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public void schedule(Runnable runnable, long time) throws InterruptedException {
        MyTask myTask = new MyTask(runnable, time);
        queue.put(myTask);
        synchronized (locker) {
            locker.notify();
        }
    }
}

public class Demo02 {
    public static void main(String[] args) throws InterruptedException {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到1！");
            }
        },3000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到2！");
            }
        },4000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到3！");
            }
        },5000);
        System.out.println("开始计时");
    }
}
