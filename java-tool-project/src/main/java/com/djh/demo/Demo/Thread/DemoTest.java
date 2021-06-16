package com.djh.demo.Demo.Thread;

import java.util.*;

public class DemoTest implements Runnable {
    private static String[] s = {"电视机", "电冰箱", "电脑", "游戏机", "洗衣机", "空调",
            "手机", "平板电脑", "电动车", "电饭煲"};
    List<String> ts = new ArrayList<>(Arrays.asList(s));
    private static List<String> list1 = new ArrayList<>();
    private static List<String> list2 = new ArrayList<>();
    private static List<String> list3 = new ArrayList<>();
    private int num = ts.size();
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (num == 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int i = (int) Math.random() * (ts.size());
                    String st = ts.get(i);
                    if (Thread.currentThread().getName() == "张三"){
                        list1.add(st);
                        System.out.println(Thread.currentThread().getName()+"抽到了："+st);
                    }else if (Thread.currentThread().getName() == "李四"){
                        list2.add(st);
                        System.out.println(Thread.currentThread().getName()+"抽到了："+st);
                    }else {
                        list3.add(st);
                        System.out.println(Thread.currentThread().getName()+"抽到了："+st);
                    }
                    num--;
                    ts.remove(i);
                }
            }
        }
    }

    public void method(){
        System.out.println("张三抽到了:"+list1);
        System.out.println("李四抽到了:"+list1);
        System.out.println("王五抽到了:"+list1);

    }
}
