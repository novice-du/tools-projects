package com.djh.excel.excel03;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.joda.time.DateTime;

import java.io.FileInputStream;
import java.util.Date;

/**
 * @author: dujunhua
 * @create: 2021/08/27 1:06
 * @description: 读取excel，获取不同类型的内容
 */
public class ExcelReadPro {
    public static final String PATH = "D:\\摇摆Sheet页1.xls";

    public static void main(String[] args) throws Exception {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH);
        //1.创建一个工作簿  excel能操作的它都能操作
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        //获取标题内容
        Row rowTitle = sheet.getRow(0);
        if (rowTitle != null) {
            //获取有多少个标题
            int cellCount = rowTitle.getPhysicalNumberOfCells();
            for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                Cell cell = rowTitle.getCell(cellNum);
                if (cell != null) {
                    int cellType = cell.getCellType();
                    String cellValue = cell.getStringCellValue();
                    //打印标题
                    System.out.println(cellValue + "|");
                }
            }
        }
        //获取所有行
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row rowData = sheet.getRow(rowNum);
            if (rowData != null) {
                //读取列
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                    System.out.println("[" + (rowNum + 1) + "-" + (cellNum + 1) + "]");

                    Cell cell = rowData.getCell(cellNum);
                    //匹配列的数据类型
                    if (cell!=null) {
                        int cellType = cell.getCellType();
                        String cellValue = "";
                        switch (cellType){
                            case HSSFCell
                                    .CELL_TYPE_STRING://字符串
                                    System.out.println(cell.getStringCellValue());
                                    break;
                            case HSSFCell
                                    .CELL_TYPE_BOOLEAN://布尔
                                    System.out.println(String.valueOf(cell.getBooleanCellValue()));
                                    break;
                            case HSSFCell
                                    .CELL_TYPE_BLANK://空
                                    break;
                            case HSSFCell
                                    .CELL_TYPE_NUMERIC://数字
                                    //判断是否是日期
                                    if (HSSFDateUtil.isCellDateFormatted(cell)){
                                        Date date = cell.getDateCellValue();
                                        cellValue = new DateTime(date).toString("yyyy-MM-dd HH:mm:ss");
                                    }else {
                                        //不是日期格式的话，防止数字过长，转换为字符串
                                        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                        cellValue = cell.toString();
                                    }
                                    break;
                            case HSSFCell
                                    .CELL_TYPE_ERROR://类型错误
                                    System.out.println("数据类型错误");
                                    break;
                        }
                        System.out.println(cellValue);
                    }
                }
            }
        }
        fileInputStream.close();
    }

}

