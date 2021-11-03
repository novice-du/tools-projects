package com.djh.easyExcel.excelWrite;
import java.util.Date;

import com.alibaba.excel.EasyExcel;
import com.djh.easyExcel.DemoData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dujunhua
 * @create: 2021/08/27 1:04
 * @description: 写入excel，获取不同类型的内容
 */
public class EasyExcelWrite {

    public static void main(String[] args) throws Exception {
        simpleWrite();
    }

    public static List<DemoData> test(){
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串"+i);
            data.setDate(new Date());
            data.setDoubleData(0.56D);
            list.add(data);
        }
        return list;
    }

    /**
     * 根据list 写入excel
     */
    public static void simpleWrite(){
        //写法一
        String fileName = "D:\\EasyExcel.xls";
        //指定用哪个实体类去写，sheet页名，文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).sheet("sheet页1").doWrite(test());

    }

}
