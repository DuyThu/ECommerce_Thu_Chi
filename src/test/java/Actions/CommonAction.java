package Actions;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CommonAction {

    public static void writeDataToExcel(int rowcount, int columncount, String value) {
        try {
            String userDir = System.getProperty("user.dir");
            String excelPath = userDir + "\\src\\Reports\\TestCaseResult.xlsx";
            FileInputStream input = new FileInputStream(excelPath);
            XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet sh = wb.getSheet("Sheet1");

            XSSFRow row = sh.getRow(rowcount);

            if(row == null) { row = sh.createRow(rowcount); }

            XSSFCell cell = row.getCell(columncount);

            if(cell == null) { cell = row.createCell(columncount); }

            cell.setCellValue(value);

            FileOutputStream fileOut = new FileOutputStream(excelPath);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
        }
    }

    public static void writeResultTestCaseToExcel(int rowCount, String name, String result, String note){
        writeDataToExcel(rowCount, 0, "" + rowCount);
        writeDataToExcel(rowCount, 1, name);
        writeDataToExcel(rowCount, 2, result);
        writeDataToExcel(rowCount, 3, note);
    }
    public static void SwitchTabPage(WebDriver driver){
        String parentWindow = driver.getWindowHandle();
        var allwindows = driver.getWindowHandles();
        for (String childWindow : allwindows) {
            if(!childWindow.equals(parentWindow))
            {
                driver.switchTo().window(childWindow);
            }
        }
    }

    public static void waitReponse(long millisSeconds) {
        try {
            Thread.sleep(millisSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
