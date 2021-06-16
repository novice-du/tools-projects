package com.djh.demo.Thread.DaemonThread;

/**
 * 守护线程:Daemon
 * 应用场景： 垃圾回收机制、线程池、监听后台时间或者状态等
 * 注意点： 守护线程需要在开启线程之间设置
 *          守护线程的结束前提是所有普通线程都结束，如果一个应用的所有线程都是守护线程，那么JVM会直接退出
 */
public class DaemonThreadDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
                System.out.println("普通线程:  "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class DamThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
                System.out.println("守护线程： "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Main{
    public static void main(String[] args) {
        DaemonThreadDemo dtd = new DaemonThreadDemo();
        Thread thread = new Thread(dtd);

        Thread thread1 = new Thread(new DamThread());
        thread1.setDaemon(true);
        thread.start();
        thread1.start();
    }
}