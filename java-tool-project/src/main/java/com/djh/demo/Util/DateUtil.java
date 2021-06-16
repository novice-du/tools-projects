package com.djh.demo.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date工具类
 */
public class DateUtil {
    /**
     * 日期转换为字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
    /**
     * 字符串转换为日期
     * @param string
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String string) throws ParseException {
        if (string.contains("/")){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return dateFormat.parse(string);
        }else if (string.contains("-")){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(string);
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
        return dateFormat.parse(string);
    }

    /**
     * 字符串转换成Long型值
     * @param string
     * @return
     * @throws ParseException
     */
    public static Long dateToLong(String string) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(string);
        return date.getTime();
    }
}
