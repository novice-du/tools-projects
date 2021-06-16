package com.djh.demo.Date;

import com.djh.demo.Util.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        //demo("2018-03-03 10:10:10","2020-04-04 10:10:10");
        try {
            System.out.println(DateUtil.stringToDate("2018年05月03 10:10:10"));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("解析异常");
        }
    }

    public static void demo(String date1, String date2){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt = format.parse(date1);
            Date dt2 = format.parse(date2);
            System.out.println(dt.after(dt2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
