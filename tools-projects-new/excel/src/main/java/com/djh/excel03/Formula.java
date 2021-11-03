package com.djh.excel03;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

/**
 * @author: dujunhua
 * @create: 2021/08/27 13:39
 * @description: 计算excel单元格里的公式
 */
public class Formula {

    public static final String PATH = "D:\\摇摆Sheet页1.xls";

    public static void main(String[] args) {
        try {
            formula();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void formula() throws Exception {

        FileInputStream fileInputStream = new FileInputStream(PATH);
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);

        //拿到计算公式eval
        FormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);

        //输出单元格内容
        int cellType = cell.getCellType();
        switch (cellType) {
            //公式
            case Cell.CELL_TYPE_FORMULA:
                String cellFormula = cell.getCellFormula();
                System.out.println(cellFormula);

                //计算
                CellValue value = formulaEvaluator.evaluate(cell);
                String cellValue = value.formatAsString();
                System.out.println(cellValue);
                break;
        }

    }
}
