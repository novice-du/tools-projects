package com.djh.demo.DesignPattern.Singleton;
/**
 * 什么是线程安全？
 * 如果你的代码所在的进程中有多个线程在同时运行，而这些线程可能会同时运行这段代码。
 * 如果每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的。
 *
 *  饿汉式：1.私有化构造器
 *          2.程序加载时直接好对象
 *          3.提供一个公共方法，将对象返回出去
 *          4.饿汉式不存在安全问题，因为在程序加载时就已创建好该唯一对象
 *
 *  这种实现方式适合单例占用内存比较小，在初始化时就会被用到的情况。但是，如果单例占用的内存比较大，
 *  或单例只是在某个特定场景下才会用到，使用饿汉模式就不合适了，这时候就需要用到懒汉模式进行延迟加载。
 *
 */
public class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();
    private Singleton2(){
    }
    public Singleton2 newInstance(){
        return singleton2;
    }
}
