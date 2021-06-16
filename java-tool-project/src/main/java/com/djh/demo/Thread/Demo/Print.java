package com.djh.demo.Thread.Demo;

/**
 * 数字字母交替输出
 */
public class Print implements Runnable {
//    boolean flag = true;   //可以通过定义一个flag，然后在while循环中判断boolean值来使线程结束
    @Override
    public void run() {
//        while (flag){
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(11);
                    System.out.println(Thread.currentThread().getName()+"输出数字"+i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//        }

    }

    public static void main(String[] args) {
        char[] chars = {'a','b','c','d','e','f','g','h','i','j'};
        Print demo = new Print();
        Thread thread = new Thread(demo);
        thread.start();
        for (int i = 0; i < chars.length; i++) {
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName()+"输出字母"+chars[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
