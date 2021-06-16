package com.djh.demo.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的生命周期: running(开始)->terminated(结束)，
 *                  running: 能接受新提交的任务，并且也能处理阻塞队列中的任务
 *                  中间状态: 1.调用shutdown()会进入shutdown状态：关闭状态，不再接受新提交的任务，但却可以继续处理阻
 *                              塞队列中已保存的任务。
 *                            2.调用shutdownNow()会进入stop状态(过于暴力不推荐使用): 不能接受新任务，也不处理队列中的
 *                              任务，会中断正在处理任务的线程。
 *                            3.阻塞队列为空，所有的任务都已终止了，workerCount (有效线程数) 为0，
 *                              线程池进入该状态后会调用 terminated() 方法进入TERMINATED 状态。
 *
 * newCachedThreadPool ：1. 线程池中数量没有固定，可达到最大值(Integer.MAX_VALUE)
 *                       2. 线程池中的线程可以进行缓存重复利用和回收(回收默认时间为1分钟)
 *                       3. 当线程池中没有可用线程时，创建新的线程
 */
public class CacheThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * execute方法执行逻辑:
         *
         * ▪ 如果当前运行的线程少于corePoolSize，则会创建新的线程来执
         * 行新的任务；
         * ▪ 如果运行的线程个数等于或者大于corePoolSize，则会将提交的
         * 任务存放到阻塞队列workQueue中；
         * ▪ 如果当前workQueue队列已满的话，则会创建新的线程来执行
         * 任务；
         * ▪ 如果线程个数已经超过了maximumPoolSize，则会使用饱和策
         * 略RejectedExecutionHandler来进行处理。
         */
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task());    //执行任务，不用再通过调用start方法启动线程
        }
        executorService.shutdown();   //关闭线程池
    }
}
