package com.djh.excel07Pro;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

import java.io.FileOutputStream;

/**
 * @author: dujunhua
 * @create: 2021/08/27 0:25
 * @description: Excel07增强版  速度快 不限行数
 */
public class ExcelWritePro {
    public static final String PATH = "D:\\";

    public static void main(String[] args) throws Exception {
        try {
            write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write() throws Exception {
        //时间
        long begin = System.currentTimeMillis();

        //1.创建一个工作簿  用SXSSFWorkbook
        Workbook workbook = new SXSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("摇摆Sheet页1");

        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("over");

        FileOutputStream outputStream = new FileOutputStream(PATH + "第一张表07Pro.xlsx");
        workbook.write(outputStream);
        outputStream.close();

        //清除缓存文件
        ((SXSSFWorkbook) workbook).dispose();
        long end = System.currentTimeMillis();
        System.out.println((double) (end - begin) / 1000);

    }
}
