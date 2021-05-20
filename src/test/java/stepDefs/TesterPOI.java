package stepDefs;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.ExcelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TesterPOI {


    public static void main(String[] args) throws IOException {

        //HSSFWorkbook -> HSSF classes are used with excel files .xls (pre 2003)







        FileInputStream fis = new FileInputStream("testData.xlsx");
        // Creating an access to an excel file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(2);
        XSSFCell cell = row.getCell(1);

        System.out.println(cell);

        int numberOfRows = sheet.getPhysicalNumberOfRows();

        System.out.println(numberOfRows);

        short noOfColumns = sheet.getRow(0).getLastCellNum();

        System.out.println(noOfColumns);

        for (int i = 0; i < numberOfRows; i++) {

            for (int j = 0; j < noOfColumns; j++) {

                System.out.print(sheet.getRow(i).getCell(j) + "\t") ;

            }
            System.out.println();

        }


        XSSFCell productCell = sheet.getRow(0).getCell(1);

        productCell.setCellValue("Outfits");

        FileOutputStream fos = new FileOutputStream("testData.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();


        ExcelUtils util = new ExcelUtils("testData.xlsx", "Sheet1");

        System.out.println(util.getCellData(1, 1));

        String[][] dataAs2DArray = util.getDataAs2DArray();

        System.out.println(Arrays.deepToString(dataAs2DArray));

        List<Map<String, String>> dataAsMap = util.getDataAsMap();

        System.out.println(dataAsMap);

        util.setCellData("Products", 0, 1);


    }
}
