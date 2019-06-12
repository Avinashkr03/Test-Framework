package basicTests;
//add maven dependency apache poi and apache poi- ooxml

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelData {
	@Test
	public void readData() throws IOException {
		//pass location of excel to FileinputStream as workbook class accepts FIS parameter
		FileInputStream fis = new FileInputStream("C:\\Users\\avinashkumar\\Documents\\Demodata.xlsx");
		//Create workbook class object and pass FIS
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		int count = wb.getNumberOfSheets();
		ArrayList<String> testdata = new ArrayList<String>();
		for (int i = 0;i<count-1;i++) {
			if(wb.getSheetName(i).equalsIgnoreCase("Testdata")) {
				XSSFSheet sheet = wb.getSheetAt(i);
				//iterarting through rows
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				//getting first row to check coloumn no of the testcases
				//celliterator will iterate on cell
				Iterator<Cell> cell = firstrow.cellIterator();
				int coloumn = 0,k = 0;
				//find coloumn no  of the testcases
				while(cell.hasNext()) {
					String value = cell.next().getStringCellValue();
					if (value.equalsIgnoreCase("Test")) {
						coloumn = k;
					}
					k++;
				}
				while (rows.hasNext()) {
					Row r = rows.next();
					String value = r.getCell(coloumn).getStringCellValue();
					if (value.equalsIgnoreCase("case3")) {
						Iterator<Cell> c = r.cellIterator();
						while(c.hasNext()){
							Cell cv = c.next();
							//checking cell value type since seperate function for extracting string 
							//and numeric data
							if(cv.getCellType()==CellType.STRING) {
								testdata.add(cv.getStringCellValue());
							}
							else {
								//converting integer type to string since our arraylist is of type string
								
								testdata.add(NumberToTextConverter.toText(cv.getNumericCellValue()));
							}
						}
						System.out.println(testdata);
					}
				}
				
			}
		}
	}

}
