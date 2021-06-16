package com.djh.demo.JUC;

import java.util.concurrent.BlockingQueue;

/**
 * @Auther:dujunhua
 * @Date:2020/9/6 21:24
 * @Description:
 */
public class Producer implements Runnable{

    private BlockingQueue<Goods> blockingQueue;

    public Producer(BlockingQueue<Goods> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Goods goods;
            if (i%2==0){
                goods = new Goods("哇哈哈","矿泉水");
            }else {
                goods = new Goods("旺仔","小馒头");
            }
//            System.out.println("生产者生产了"+goods.getBrand()+goods.getName());
            System.out.println("生产者生产了"+i);
            try {
                blockingQueue.put(goods);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
