package com.pages;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcelData {

    public List<Map<String,String>> readTestData() throws IOException {
        File file = new File("src/main/resources/TestData/userData.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row;
        XSSFCell cell;

        List<Map<String,String>> userData = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            Map<String,String> userData1 = new HashMap<>();
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                userData1.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i+1).getCell(j).getStringCellValue().trim());
            }
            userData.add(userData1);
        }
        return userData;
    }

    public  List<Map<String,Integer>> numaricData () throws IOException {
        List<Map<String,Integer>>  numaricData = new ArrayList<>();
        
        File file = new File("src/main/resources/TestData/userData.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(1);

        for (int i = 0; i < 1; i++) {
            Map<String,Integer> userData1 = new HashMap<>();
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                userData1.put(sheet.getRow(0).getCell(j).getStringCellValue(), (int) sheet.getRow(i+1).getCell(j).getNumericCellValue());
            }
            numaricData.add(userData1);
        }
        return numaricData;
    }

}
