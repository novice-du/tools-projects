package com.djh.demo.Date;

import java.text.DateFormat;
import java.util.Date;

/*
 * DateFormat是一个abstract类，不能直接实例化，但是可以调用其方法.getDateInstance()来返回一个DateFormat对象
 * 然后通过此对象，调用DateFormat中的方法
 *
 * 多种日期风格FULL,LONG,MEDIUM,SHORT
 */

public class DateFormatDemo {

    public static void main(String[] args) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT); //日期风格
        String format = df.format(new Date());      //.format方法，传进一个日期格式参数，返回一个String字符串
        System.out.println(format);

        DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.LONG); //日期+时间风格
        System.out.println(df2.format(new Date()));
    }
}
