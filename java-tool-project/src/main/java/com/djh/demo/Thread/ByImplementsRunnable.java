package com.djh.demo.Thread;

/**
 * Runnable接口中没有start方法，所以不能直接用ByImplementsRunnable调用start方法，
 * Thread也实现了Runnable接口，而且Thread中的构造方法中有Thread(Runnable target)
 * 所以通过向上转型，可以将ByImplementsRunnable的对象传给Thread构造器获得Thread对象调用start方法
 *
 * 问题：为什么执行的是自定义线程中的任务而不是Thread中的任务
 * public void run(){
 *     if(target！=null){
 *         target.run();
 *     }
 * }
 *
 * 线程的执行是存在随机性的
 *
 * 推荐使用实现Runnable接口的原因:
 * 1.java是单继承，将继承关系留给最需要的类
 * 2.使用Runnable接口之后不需要给共享变量添加startic关键字，创建一个对象，作为共享对象即可
 */
public class ByImplementsRunnable implements Runnable {
    public static void main(String[] args) {
        ByImplementsRunnable runnable = new ByImplementsRunnable();
        Thread thread = new Thread(runnable);           //用到了代理设计模式
        thread.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("-----run()-----");
        }
    }
}
