package com.djh.demo.Demo.Thread;

public class DemoMethod {
    public static void main(String[] args) {
        DemoTest test = new DemoTest();
        Thread t1 = new Thread(test, "张三");
        Thread t2 = new Thread(test, "李四");
        Thread t3 = new Thread(test, "王五");

        t1.start();
        t2.start();
        t3.start();

        DemoTest method = new DemoTest();
        method.method();
    }
}
