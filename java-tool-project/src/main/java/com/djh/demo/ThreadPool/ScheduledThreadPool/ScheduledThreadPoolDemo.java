package com.djh.demo.ThreadPool.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPool用来执行线程的定时任务
 *
 * newScheduledThreadPool 用来实现线程的延迟执行
 */
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟三秒执行");
            }
        },3,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
