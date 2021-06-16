package com.djh.demo.Demo.Thread;
import java.util.*;
public class Box extends Thread {
    private static String[] s = {"电视机", "电冰箱", "电脑", "游戏机", "洗衣机", "空调",
            "手机", "平板电脑", "电动车", "电饭煲"};
    ArrayList<String> ts = new ArrayList<>(Arrays.asList(s));
    private static HashMap<String, String> hm = new HashMap<>();
    private int num = ts.size();
    Random r = new Random();
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
                    int i = r.nextInt(num);
                    num--;
                    if (hm.containsKey(Thread.currentThread().getName())) {
                        String newValue = hm.get(Thread.currentThread().getName());
                        newValue = newValue + "," + ts.get(i);
                        hm.put(Thread.currentThread().getName(), newValue);
                        ts.remove(i);
                    } else {
                        hm.put(Thread.currentThread().getName(), ts.get(i));
                        ts.remove(i);
                    }
                    System.out.println(Thread.currentThread().getName() + "抽到了" + ts.get(i));
                }
            }
        }
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }
    }
}
