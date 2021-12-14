package com.Util;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Helper {
    public static Object[][] readDataFromEcxelSheet() throws IOException {
        File file = new File("src/main/resources/TestData/userData.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(2);

        int rowCount = sheet.getLastRowNum();
        int colCnt = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount + 1][colCnt];

        System.out.println(rowCount + "row");
        System.out.println(colCnt + "col");

        for (int i = 0; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            colCnt = sheet.getRow(i).getLastCellNum();

            for (int j = 0; j < colCnt; j++) {
                XSSFCell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j] = cell.getNumericCellValue();
                        break;
                }
            }
        }
        return data;
    }
}


