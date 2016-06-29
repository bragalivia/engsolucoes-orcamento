package business;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import rest.model.Insumo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Livia on 16/06/2016.
 */
public class ImportExcel {
    public List<Insumo> readExcel(String fileName, String sourceDatabaseName) {
        List<Insumo> insumoList = new ArrayList<Insumo>();
        try {
            FileInputStream input = new FileInputStream(fileName);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(input);
            Sheet sheet = myWorkBook.getSheetAt(0);
            Row row;

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = (Row) sheet.getRow(i);
                Double code = row.getCell(0).getNumericCellValue();
                String description = row.getCell(1).getStringCellValue();
                String unity = row.getCell(2).getStringCellValue();
                Double price = row.getCell(3).getNumericCellValue();

                Insumo insumo = new Insumo();
                insumo.setSource(sourceDatabaseName);
                insumo.setCode(code.intValue());
                insumo.setDescription(description);
                insumo.setUnity(unity);
                insumo.setPrice(price);
                insumoList.add(insumo);
            }
            input.close();
            System.out.println("Success import excel to mysql table");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return insumoList;
    }
    public void importExcel() {

    }
}
