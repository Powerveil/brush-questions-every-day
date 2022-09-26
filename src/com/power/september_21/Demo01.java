package com.power.september_21;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo01 {
    public static void main(String[] args) {
        // 标准库的定时器
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到，3s了");
            }
        },3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到，4s了");
            }
        },4000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到，5s了");
            }
        },5000);
        System.out.println("开始计时");
    }
}
