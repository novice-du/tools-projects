package com.djh.demo.DesignPattern.Singleton;

/**
 * 单例模式:
 * 单件模式属于工厂模式的特例，只是它不需要输入参数并且始终返回同一对象的引用.
 *
 * 懒汉式：1.私有化构造器
 *         2.提供一个公有的方法来获取对象，且是静态的，可以通过类名调用
 *         3.私有化变量（对象）
 *         4.加入同步锁会提高安全性，但会影响效率，因为每次调用创建对象的方法时会先判断同步锁。耗资源
 *         5.在同步锁外再加一层判断，提高效率
 */
public class Singleton1 {
    private static Singleton1 singleton = null;

    private Singleton1() {
    }
    public static Singleton1 newInstance() {
        if (singleton == null) {                    //双重检查
            synchronized (Singleton1.class) {
                if (singleton == null) {
                    return new Singleton1();
                }
            }
        }
        return singleton;
    }
}
