package com.djh.demo.JUC;

import java.util.concurrent.BlockingQueue;

/**
 * @Auther:dujunhua
 * @Date:2020/9/6 21:35
 * @Description:
 */
public class Consumer implements Runnable {
    
    private BlockingQueue<Goods> blockingQueue;

    public Consumer(BlockingQueue<Goods> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Goods goods;
            try {
                goods = blockingQueue.take();
//                System.out.println("消费者消费了"+goods.getBrand()+goods.getName());
                System.out.println("消费者消费了"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
