package com.djh.demo.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  线程池中最多执行一个线程,之后提交的线程活动将会在队列中等待
 */
public class SingleThreadPoolDemo {
    public static void main(String[] args) {
        //线程池中只有一个线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }
}
