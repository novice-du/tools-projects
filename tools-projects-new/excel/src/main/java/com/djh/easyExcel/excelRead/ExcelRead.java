package com.djh.easyExcel.excelRead;

import com.alibaba.excel.EasyExcel;
import com.djh.easyExcel.DemoData;

/**
 * @author: dujunhua
 * @create: 2021/08/27 14:27
 * @description:
 */
public class ExcelRead {

    public static void main(String[] args) {
        simpleRead();
    }

    public static void simpleRead(){
        String fileName = "D:\\EasyExcel.xls";
        //指定用哪个class去读，然后取第一个sheet页，文件流会自动关闭
        //DemoDataListener不能被spring管理，需要每次读的时候new,然后里面用到spring可以构造方法传进去
        EasyExcel.read(fileName, DemoData.class,new DemoDataListener()).sheet().doRead();
    }
}
