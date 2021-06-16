package com.djh.demo.Thread.SaleTicket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
 * 2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；表示执行这个方法的当前对象被锁定。
 * 3. 修饰一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
 * 4. 修饰一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象
 *
 * 对象锁: 也叫方法锁，是针对一个对象实例的，它只在该对象的某个内存位置声明一个标识该对象是否拥有锁，所以它只会锁住当前的对象，
 * 而并不会对其他对象实例的锁产生任何影响，不同对象访问同一个被synchronized修饰的方法的时候不会阻塞
 *
 * 类锁: 是锁住整个类，当有多个线程来声明这个类的对象时候将会被阻塞，直到拥有这个类锁的对象被销毁或者主动释放了类锁，
 * 这个时候在被阻塞的线程被挑选出一个占有该类锁，声明该类的对象。其他线程继续被阻塞住
 * synchronized修饰静态方法属于类锁,无论线程调用的是多少个对象实例的方法,都会同步
 *
 * sleep和wait的区别:
 *  sleep睡眠（静态方法），过了睡眠时间会自动醒，仍然持有锁    Thread.sleep() 当前线程睡眠
 *  wait等待，无限期（但也可以加上等待时间） 需要被别的线程唤醒（notify方法），会释放锁
 * Thread.Sleep(0)的作用，就是“触发操作系统立刻重新进行一次CPU竞争”
 * 因为这样就给了其他线程比如Paint线程获得CPU控制权的权力，这样界面就不会假死在那里。
 *
 *  join: 合并线程，t1.join()将线程t1和主线程合并，然后执行完t1这个线程，再执行主线程。
 *  yield：当前正在执行得线程暂停一次，允许其他线程执行，不阻塞，线程进入就绪状态，如果没有其他等待的线程，当前线程会立马恢复执行
 *  interrupt() 中断线程(如果线程正在sleep，则线程会抛出InterruptedException异常)，在捕获异常中的(catch{})里，可以return。让线程结束(不是让线程结束的最好方法)
 *  stop：强迫线程停止，已过时，不推荐使用
 */
public class TicketDemo2 {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static int num = 10;
    public synchronized void method1() {
        for (int i = 0; i < 10; i++) {
            logger.info("====");
            if (num>0) {
                try {
                    Thread.sleep(30);
                    System.out.println(Thread.currentThread().getName() + "卖掉一张票，剩余：" + (--num));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    public synchronized void method2() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(30);
                System.out.println(Thread.currentThread().getName() + "====" + i + "====");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        TicketDemo2 ticketDemo2 = new TicketDemo2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ticketDemo2.method1();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ticketDemo2.method2();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}