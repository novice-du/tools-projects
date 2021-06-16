package com.djh.demo.Thread;

/**
 * 进程：指在系统中正在运行的一个应用程序
 * 线程：进程中的单个执行单元
 * 一个进程中最少有两个线程：
 * 主线程
 * 垃圾回收机制：不定期清理
 * 主动告诉垃圾回收器清理，但是通知完后不一定会及时清理（System.gc()）---弱引用、强引用
 *
 * 创建线程的两种方式：
 * 一：继承Thread类，重写run方法，调用start方法创建并开启线程
 * 二：实现Runnable接口，重写run方法，创建Thread对象关联Runnable中的任务，调用start方法创建并开启线程
 */
public class ByExtendsThrread extends Thread {   //因为类不能多继承，所以这种方式不推荐使用
    public static void main(String[] args) {
        new ByExtendsThrread().start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("====thread===");
        }
    }
}
