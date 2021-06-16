package com.djh.demo.Date.Calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * 在 JDK 1.1 之前，类 Date 有两个其他的函数。它允许把日期解释为年、月、日、小时、分钟和秒值。
 * 它也允许格式化和解析日期字符串。
 * 不过，这些函数的 API 不易于实现国际化。从 JDK 1.1 开始，应该使用 Calendar 类实现日期和时间字段之间转换，
 * 使用 DateFormat 类来格式化和解析日期字符串
 */
public class CalenderDemo {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        //calendar.add(Calendar.YEAR,-1);  //年份减一年
        //Date date = calendar.getTime();  //calendar对象转换为Date对象

        long millis = calendar.getTimeInMillis();  //转为Long型值（毫秒数）
        System.out.println(millis);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String minutes = check(calendar.get(Calendar.MINUTE));
        String second = check(calendar.get(Calendar.SECOND));
//        int minutes = calendar.get(Calendar.MINUTE);
//        int second = calendar.get(Calendar.SECOND);
        System.out.println(year+"/"+month+"/"+day+" "+hour+":"+minutes+":"+second);
    }

    //如果分或秒为个位数，调用该方法，变成两位数，并改为String类型
    public static String check(int i){
        String mintus = "";
        String second = "";
        if (i<10){
            mintus = "0"+i;
            return mintus;
        }
        second = i+"";
        return second;
    }
}
