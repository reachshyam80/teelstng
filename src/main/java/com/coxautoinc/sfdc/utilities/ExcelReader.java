package com.coxautoinc.sfdc.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Contains logic to read from Excel sheets
 */
class ExcelReader {

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Method to get the desired excel spreadsheet
     *
     * @param filePath in value
     * @param sheetName in value
     *
     * @return HashMap with excel data
     *
     * @throws Exception on error
     */
    HashMap<String, List<String>> getExcel(String filePath, String sheetName) throws Exception {
        HashMap<String, List<String>> sheetData = new HashMap<>();
        DataFormatter formatter = new DataFormatter();

        FileInputStream fis = null;
        try {
            if (filePath.endsWith(".xls")) {
                fis = new FileInputStream(filePath);
                HSSFWorkbook workbook = new HSSFWorkbook(fis);
                HSSFSheet sheet = workbook.getSheet(sheetName);
                Iterator rows = sheet.rowIterator();
                List<String> keyRow = new ArrayList<>();
                HSSFRow row = (HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();

                while (cells.hasNext()) {
                    String cell = formatter.formatCellValue(cells.next());
                    keyRow.add(cell);
                }
                int rowAt = 0;
                while (rows.hasNext()) {
                    row = (HSSFRow) rows.next();
                    cells = row.cellIterator();
                    List<String> data = new ArrayList<>();
                    while (cells.hasNext()) {
                        String cell = formatter.formatCellValue(cells.next());
                        data.add(cell);
                    }
                    sheetData.put(keyRow.get(rowAt), data);
                    rowAt++;
                }
                workbook.close();
            } else {
                if (filePath.endsWith(".xlsx")) {
                    fis = new FileInputStream(filePath);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheet(sheetName);
                    Iterator rows = sheet.rowIterator();
                    List<String> keyRow = new ArrayList<>();
                    XSSFRow row = (XSSFRow) rows.next();
                    Iterator<Cell> cells = row.cellIterator();

                    while (cells.hasNext()) {
                        String cell = formatter.formatCellValue(cells.next());
                        keyRow.add(cell);
                    }
                    while (rows.hasNext()) {
                        row = (XSSFRow) rows.next();
                        cells = row.cellIterator();
                        List<String> data = new ArrayList<>();
                        while (cells.hasNext()) {
                            String cell = formatter.formatCellValue(cells.next());
                            data.add(cell);
                        }
                        for (int i = 0; i < keyRow.size(); i++) {
                            if (sheetData.get(keyRow.get(i)) == null) {
                                final int finalI = i;
                                List<String> tempList =
                                    new ArrayList<String>() {
                                        {
                                            add(data.get(finalI));
                                        }
                                    };
                                sheetData.put(keyRow.get(i), tempList);
                            } else {
                                List<String> tempList = sheetData.get(keyRow.get(i));
                                tempList.add(data.get(i));
                                sheetData.put(keyRow.get(i), tempList);
                            }
                        }
                    }
                    workbook.close();
                } else {
                    throw new IOException("Incorrect file type for Excel Reader");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return sheetData;
    }
}
