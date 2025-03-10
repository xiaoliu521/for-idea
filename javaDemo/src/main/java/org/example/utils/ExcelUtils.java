package org.example.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ExcelUtils {

    // 读取 Excel 文件
    public static List<List<String>> readExcel(String filePath) throws IOException {
        List<List<String>> data = new ArrayList<>();

        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            List<String> rowData = new ArrayList<>();
            for (Cell cell : row) {
                rowData.add(getCellValueAsString(cell));
            }
            data.add(rowData);
        }

        workbook.close();
        fis.close();

        return data;
    }

    // 写入 Excel 文件
    public static void writeExcel(String filePath, List<List<String>> data) throws IOException {
        Workbook workbook;

        if (filePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (filePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }

        Sheet sheet = workbook.createSheet("Sheet1");

        int rowNum = 0;
        for (List<String> rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (String cellData : rowData) {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(cellData);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }

        workbook.close();
    }

    // 获取单元格的字符串值
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }

    // 示例用法
    public static void main(String[] args) {
        try {
            // 读取 Excel 文件
            List<List<String>> data = readExcel("example.xlsx");
            for (List<String> row : data) {
                System.out.println(row);
            }

            // 写入 Excel 文件
            List<List<String>> newData = new ArrayList<>();
            newData.add(Arrays.asList("Name", "Age", "City"));
            newData.add(Arrays.asList("Alice", "30", "New York"));
            newData.add(Arrays.asList("Bob", "25", "San Francisco"));
            writeExcel("output.xlsx", newData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
