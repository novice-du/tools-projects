package com.djh.excel.excelRead;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author: dujunhua
 * @create: 2021/08/27 1:04
 * @description: 读取excel，获取不同类型的内容
 */
public class ExcelRead {

    public static final String PATH = "D:\\摇摆Sheet页1.xlsx";

    public static void main(String[] args) throws Exception {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH);
        //1.创建一个工作簿  excel能操作的它都能操作
        Workbook workbook = new XSSFWorkbook(fileInputStream);
    }
}
