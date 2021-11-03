package com.djh.excel03;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;

import java.io.FileOutputStream;

/**
 * @author: dujunhua
 * @create: 2021/08/26 23:51
 * @description: Excel03版本写入  速度快  但是有行数限制，最大65536行
 */

public class ExcelWrite {

    public static final String PATH = "D:\\";

    public static void main(String[] args) throws Exception {
        try {
             write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write() throws Exception {
        //1.创建一个工作簿  用HSSFWorkbook
        Workbook workbook = new HSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("摇摆Sheet页1");
        //3.创建一行（1.1）
        Row row1 = sheet.createRow(0);
        //4.创建一个单元格
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("第一行第一格");
        Cell cell2 = row1.createCell(1);
        cell2.setCellValue("第一行第二格");

        //5.创建第二行
        Row row2 = sheet.createRow(1);
        //6.创建一个单元格
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("第二行第一格");
        Cell cell22 = row2.createCell(1);
        String str = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue("第二行第二格"+str);

        //生成一张表（IO流）
        FileOutputStream outputStream = new FileOutputStream(PATH + "第一张表03.xls");
        workbook.write(outputStream);
        outputStream.close();
    }
}
