package com.djh.demo.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个可以指定线程数量的线程池
 */
public class FixedThreadPoolDemo {

    public static void main(String[] args) {
        //设置线程池中线程个数
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }
}
