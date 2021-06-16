package com.djh.demo.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

    public static void main(String[] args) {
        //日期转换为字符串
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH：mm：ss"); //自定义日期格式
        String format = dateFormat.format(new Date());
        System.out.println(format);  //输出的是一个字符串

        //字符串转换为日期
        String string = "2020-3-4 23:29:30";
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = format1.parse(string);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
