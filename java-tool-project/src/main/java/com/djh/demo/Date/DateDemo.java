package com.djh.demo.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String st = "2020/10/22 59:59:59";
        String st2 = "2020/10/21 59:59:59";
        Long time = 1603511999000L;
        Date date2 = new Date(time);
        System.out.println(date.getTime());           //输出：日期转换成long型后的值
        System.out.println(date2);                    //输出：传入long型参数后转换成Date类型的值
        System.out.println(date.after(date2));        //输出：当前日期是否在参数日期之后，返回的是loolean值
        System.out.println(date.before(date2));       //输出：当前日期是否在参数日期之前，返回的是loolean值
        System.out.println(date.compareTo(date2));    //输出：当前日期是否在参数日期之后，返回的是值int值，是的话为1，不是为-1，相等为0

        System.out.println(format.format(date2));
        System.out.println(format.parse(st).getTime());
        System.out.println(format.parse(st2).getTime());
        System.out.println(format.format(new Date(1603425599000L)));
    }
}
