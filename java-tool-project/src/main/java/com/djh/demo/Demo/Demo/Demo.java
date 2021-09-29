package com.djh.demo.Demo.Demo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: dujunhua
 * @Create: 2021/04/22 18:40
 * @Description:
 */
public class Demo {


    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        String form = "2021-09-26 08:05:03";
        int strH = Integer.parseInt(form.substring(11, 13));
        int strM = Integer.parseInt(form.substring(14, 16));

        if (strH>=8){
            if (strM>=30){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.HOUR_OF_DAY, 8);
                calendar.set(Calendar.MINUTE, 30);
                calendar.set(Calendar.SECOND, 0);

                Date date2 = calendar.getTime();
                String format2 = dateFormat.format(date2);
                System.out.println("这是今天的时间"+format2);
            }
            System.out.println("不到八点半");
        }else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, -24);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 0);

            Date date2 = calendar.getTime();
            String format2 = dateFormat.format(date2);
            System.out.println("这是昨天的时间"+format2);
        }
    }

}
