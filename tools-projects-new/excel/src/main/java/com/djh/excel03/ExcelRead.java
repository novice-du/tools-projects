package com.djh.excel03;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author: dujunhua
 * @create: 2021/08/27 0:49
 * @description: Excel03版本读取
 */
public class ExcelRead {

    public static final String PATH = "D:\\摇摆Sheet页1.xlsx";

    public static void main(String[] args) {
        try {
            write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write() throws Exception {

        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH);
        //1.创建一个工作簿  excel能操作的它都能操作
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        //2.得到表 可以根据下标也可以根据名字
        Sheet sheet = workbook.getSheetAt(0);
        //3.得到行
        Row row = sheet.getRow(0);
        //4.得到列
        Cell cell = row.getCell(0);
        //获取字符串类型
        //System.out.println(cell.getStringCellValue());
        //获取数字类型
        System.out.println(cell.getNumericCellValue());

        fileInputStream.close();
    }
}
