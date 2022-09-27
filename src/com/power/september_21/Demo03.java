package com.power.september_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo03 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务...");
            }
        });
    }
}
