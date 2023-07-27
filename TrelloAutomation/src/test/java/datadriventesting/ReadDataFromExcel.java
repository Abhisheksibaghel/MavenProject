package datadriventesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
public static void main(String[] args) throws Throwable {
	FileInputStream file=new FileInputStream("./src/test/resources/sele.xlsx");
	Workbook workbook=WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet("selenium");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(1);
	String cellvalue = cell.getStringCellValue();
	System.out.println(cellvalue);
	Row row1 = sheet.getRow(1);
	Cell cellvalue1 = row1.getCell(1);
	long valueofcell = (long) cellvalue1.getNumericCellValue();
	System.out.println(valueofcell);
	workbook.close();
	
}
}
