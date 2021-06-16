package com.djh.demo.Thread.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 抽奖业务
 */
public class LuckyDraw implements Runnable {

    private static String[] str = {"电视机", "电饭煲", "游戏机", "冰箱", "手机", "吹风机", "空调", "手表", "水壶", "雨伞"};
    List<String> list = Arrays.asList(str);
    List<String> arrayList = new ArrayList(list);
    private int num = list.size();
    private boolean flag = true;

    private List<String> list1 = new ArrayList();
    private List<String> list2 = new ArrayList();
    private List<String> list3 = new ArrayList();
    Random r = new Random();

    @Override
    public void run() {
        Object o = new Object();
        while (true) {
            synchronized (this) {
                if (num == 0) {
                    if (flag == true){
                        synchronized (o) {
                            System.out.println("张三抽到了：" + list1);
                            System.out.println("李四抽到了：" + list2);
                            System.out.println("王五抽到了：" + list3);
                            flag = false;
                        }
                    }
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int nextInt = r.nextInt(num);
                    String name = arrayList.get(nextInt);
//                    System.out.println(Thread.currentThread().getName() + "抽到了: " + name);
                    if (Thread.currentThread().getName() == "张三") {
                        list1.add(name);
                    } else if (Thread.currentThread().getName() == "李四") {
                        list2.add(name);
                    } else {
                        list3.add(name);
                    }
                    arrayList.remove(name);
                    num--;
                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        LuckyDraw demo = new LuckyDraw();
        Thread thread1 = new Thread(demo, "张三");
        Thread thread2 = new Thread(demo, "李四");
        Thread thread3 = new Thread(demo, "王五");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}