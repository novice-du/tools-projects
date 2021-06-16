package com.djh.demo.ThreadPool.ThreadPoolExecutor;


public class Task implements Runnable {
    @Override
    public void run() {
        //不过不睡一秒(执行时间很短，线程池中的线程就可以出现复用效果)
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName()+"running");
    }
}
