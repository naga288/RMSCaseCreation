package resources;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
static 	XSSFWorkbook workbook;
static 	XSSFSheet sheet;
	public ExcelDataConfig(String Excelpath, String sheetName) throws Exception {
try {
	File src=new File(Excelpath);
			
			FileInputStream fis=new FileInputStream(src);
			
			 workbook=new XSSFWorkbook(fis); 
			 sheet=workbook.getSheet(sheetName);
} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
}
	}
	
	public int getRowCount() {
		int rowcount=0;
		try {
			 rowcount=sheet.getPhysicalNumberOfRows();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcount;
	}

	
	public int getColCount() {
		int colCount=0;
		try {
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colCount;
	}
	
	public String getCellData( int RowNum, int ColNum) {
		String cellData = null;
		try {
			cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellData;
			
		} 
	
	public double getCellDataNum(int RowNum,int ColNum) {
		double cellData=0;
		try {
			cellData=sheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellData;
	}
		
	}

