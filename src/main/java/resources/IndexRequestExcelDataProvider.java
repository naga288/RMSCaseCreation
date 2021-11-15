package resources;

import org.testng.annotations.DataProvider;

public class IndexRequestExcelDataProvider {
	
	
	@DataProvider(name="ExcelData")
	public  Object[][] getdata() throws Exception {
		String excelpath="C:\\Users\\nagababu.parepalli\\eclipse-workspace\\RmsCustomerPortal\\src\\main\\java\\resources\\RMSTestData.xlsx";
		String sheetName="index";
	Object data[][]=testData(excelpath,sheetName);
	return data;
	}

	public  Object[][] testData(String excelPath, String sheetName) throws Exception {
	ExcelDataConfig excel=new ExcelDataConfig(excelPath,sheetName);
	
	int rowcount=excel.getRowCount();
	int colcount=excel.getColCount();

	Object data[][]= new Object[rowcount-1][colcount];
	
	for (int i=1;i<rowcount;i++) {
		for(int j=0;j<colcount;j++) {
			String cellData=excel.getCellData(i,j);
			data[i-1][j]=cellData;
		}
	}
	return data;
	}
	
}
