package com.djh.demo.Demo.Thread;

import com.djh.demo.Demo.Thread.Box;

public class Test09 {
    public static void main(String[] args) {
        Box box = new Box();
        //ArrayBlockingQueue lock = new ArrayBlockingQueue(1);
        Thread t1 = new Thread(box, "张三");
        Thread t2 = new Thread(box, "李四");
        Thread t3 = new Thread(box, "王五");
        t2.setPriority(10);
        t1.start();
        t2.start();
        t3.start();

    }
}
