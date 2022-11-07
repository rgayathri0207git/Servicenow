package servicenow.utilities;

import java.io.IOException;



import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelData {


	public static String[][] readExcel(String fileName) throws IOException {


		XSSFWorkbook Workbook = new XSSFWorkbook("./TestData/"+fileName+".xlsx");
		XSSFSheet sheet = Workbook.getSheet("Sheet1");

		int lastRowNum = sheet.getLastRowNum();		
		int lastCellNum = sheet.getRow(0).getLastCellNum();		
		String[][] data=new String[lastRowNum][lastCellNum];
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				String stringCellValue = row.getCell(j).getStringCellValue();				
				data[i-1][j]=stringCellValue;
			}			
		}

		Workbook.close();
		return data;
	}

}
