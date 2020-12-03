package excel;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class Excel {

    private XSSFSheet sheet;

    public Excel() {
        this.getExcelSheet();
    }

    public XSSFSheet getSheet() {
        return this.sheet;
    }

    public void setSheet(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    public void getExcelSheet() {
        try {
            FileInputStream file = new FileInputStream(new File("sheet.xlsx"));

            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            this.setSheet(sheet);

            // Close Streams
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printSheetContent() {
        try {
            // Get first/desired sheet from the workbook
            XSSFSheet sheet = this.getSheet();

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                // System.out.println(row.getLastCellNum());

                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    // Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t" + "\t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t" + "\t");
                            break;
                        default:
                            break;
                    }
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> populateClass() {
        List<Student> list = new ArrayList<Student>();
        try {
            // Get first/desired sheet from the workbook
            XSSFSheet sheet = this.getSheet();

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() != 0) {
                    Math math = new Math(row.getCell(1).getNumericCellValue());
                    Science science = new Science(row.getCell(2).getNumericCellValue());
                    Language language = new Language(row.getCell(3).getNumericCellValue());

                    Student student = new Student(row.getRowNum(), row.getCell(0).getStringCellValue(), math, science,
                            language);
                    list.add(student);
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
