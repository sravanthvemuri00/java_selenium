package reusable;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    public static String getSheet(String sheetname, int row, int col) throws IOException {
        File f = new File("src/main/resources/data/~$testdataauto.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook workbook =new XSSFWorkbook(fis);
        XSSFSheet sheet= workbook.getSheet(sheetname);
        String sam=sheet.getRow(row).getCell(col).getStringCellValue();
        return sam;
    }
}

//XSSFWorkbook work = new XSSFWorkbook(fis);
//XSSFSheet sheet = work.getSheet(sheetname);
//String sam = sheet.getRow(row).getCell(col).getStringCellValue();