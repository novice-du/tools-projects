package com.djh.demo.Thread.SaleTicket;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 多线程存在安全问题：一个线程在运算时被其他线程干预
 * 解决办法：同步锁（安全、效率慢）
 */
@NoArgsConstructor
@AllArgsConstructor
public class TicketDemo implements Runnable {
    private String name;
    int num = 200;

    public TicketDemo(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        while (true) {
/*             synchronized (TicketDemo.class){
             }*/
            sale();
        }
    }
    //synchronized同步锁可以锁方法，也可以锁代码
    public synchronized void sale() {   //持有一个this对象（唯一对象）
        if ((num > 0)) {
            try {
                Thread.sleep(10);
                //返回对当前正在执行的线程对象的引用。getName()获取此线程名称
                System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩下" + (--num));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Ticket {
    public static void main(String[] args) {
        TicketDemo ru = new TicketDemo("张三");
        Thread t1 = new Thread(ru);
        t1.start();
        Thread t2 = new Thread(ru);
        t2.start();
    }
}