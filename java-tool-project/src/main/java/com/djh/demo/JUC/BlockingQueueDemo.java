package com.djh.demo.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列 BlockingQueue
 *
 * Java util.concurrent包下重要的数据结构，BlockingQueue提供了线程安全的队列访问方式：
 * 当阻塞队列进行插入数据时，如果队列已满，线程将会阻塞等待直到队列非满；从阻塞队列取
 * 数据时，如果队列已空，线程将会阻塞等待直到队列非空。并发包下很多高级同步类的实现都
 * 是基于BlockingQueue实现的。
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        //定义队列长度
        BlockingQueue<Goods> goods = new ArrayBlockingQueue<>(5);

        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
