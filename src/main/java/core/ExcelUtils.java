package core;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public static Object[][] getTableArray (String filePath, String sheetName, int startCol, int totalCol){
        String[][] tableArray = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
            int startRow = 1; //row 0 la title
            int ci, cj;
            int totalRows = xssfSheet.getLastRowNum();
            ci =0;
            tableArray = new String[totalRows][totalCol];
            for(int i=startRow; i<= totalRows; i++, ci++){
                cj=0;
                for(int j=startCol;j<totalCol;j++,cj++){
                    XSSFCell cell = xssfSheet.getRow(i).getCell(j);
                    tableArray[ci][cj]= cell.getStringCellValue();
                }
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tableArray;
    }

    public static void writeTestResults(String filePath, String sheetName, int startRow, int resultCol, String[] testResults) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);

            for (int i = startRow; i < startRow + testResults.length; i++) {
                Row row = xssfSheet.getRow(i);
                if (row == null) {
                    row = xssfSheet.createRow(i);
                }

                Cell resultCell = row.createCell(resultCol);
                resultCell.setCellValue(testResults[i - startRow]);
            }

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            xssfWorkbook.write(fileOutputStream);
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
