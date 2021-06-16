package com.djh.demo.Demo.Date;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


public class Demo1 {
    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String str1 = "2020/10/22 00:00:00";
        String str2 = "2020/10/22 59:59:59";

        Calendar calendar = Calendar.getInstance();
        Date date = dateFormat.parse(str1);
        calendar.setTime(date);
        System.out.println(dateFormat.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        String start = dateFormat.format(calendar.getTime());
        System.out.println(start);

        Date date2 = dateFormat.parse(str2);
        calendar.setTime(date2);
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        System.out.println(dateFormat.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        String end = dateFormat.format(calendar.getTime());
        System.out.println(end);
    }
}

