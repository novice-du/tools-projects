package com.djh.demo.Thread.SaleTicket;

/**
 * @Auther:dujunhua
 * @Date:2020/8/28 21:48
 * @Description:
 */
public class Demo2 implements Runnable{

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(Thread.currentThread().getName()+"卖第"+i+"张票");
        }
    }
}

class Demo3{

    private int ticket = 5;
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        Thread thread = new Thread(demo2);
        thread.start();
        for (int i = 5; i > 0; i--) {
            System.out.println(Thread.currentThread().getName()+"卖第"+i+"张票");
        }
    }
}
