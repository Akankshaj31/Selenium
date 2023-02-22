package datapakg;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexcel1 {
	public static void main(String[] args) throws IOException {
		  String filelocation = "./test-data/Login-data.xlsx";
			XSSFWorkbook wbook = new XSSFWorkbook(filelocation);
			XSSFSheet sheet = wbook.getSheetAt(0);
			
			int rowcount = sheet.getLastRowNum();
			int physicalNumberofRows = sheet.getPhysicalNumberOfRows();
			System.out.println("physicalNumberofRows : "+physicalNumberofRows);
			System.out.println("No.of Rows"+ rowcount);
			short lastcellnum = sheet.getRow(0).getLastCellNum();
			System.out.println("No.of cells : "+lastcellnum);
			for (int i = 1; i <= rowcount; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < lastcellnum; j++) {
					XSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.println(value);
				} 
			}
			wbook.close();
	  }
}
