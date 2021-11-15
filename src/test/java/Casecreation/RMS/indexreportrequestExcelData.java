package Casecreation.RMS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RMSV2.RMSCustomerPortal.RMS_access_methods;
import RMSV2.RMSCustomerPortal.RMS_request_methods2;
import resources.IndexRequestExcelDataProvider;
import resources.ProviderRequestExcelDataProvider;
import resources.driverClass;

public class indexreportrequestExcelData extends driverClass {
	public static WebDriver driver;
	RMS_request_methods2 request = new RMS_request_methods2();

	@BeforeTest
	public void browser() throws Exception {
		driver = intializedriver();
		
	}

	@Test(priority = 1,dataProvider = "RMSAccess", dataProviderClass = ProviderRequestExcelDataProvider.class)
	public void login(String Env,String UserName,String Password) throws IOException, InterruptedException {
		RMS_access_methods signin = new RMS_access_methods();
		signin.login(driver,Env, UserName, Password);

	}
	@Test(dataProvider = "ExcelData", dataProviderClass = IndexRequestExcelDataProvider.class, dependsOnMethods = { "login" })
	public void IndexOnlyRequest(String firstName, String SSN, String dob, String streetAdd, String city,
			String postalCode, String phnum,String NeedByDate, String RecordsNeededFor, String AuthorizingPhysician,
			String PurposeOfRequest,String filetype) throws InterruptedException, IOException {
		request.patientdemographics(driver);
		request.chooseRetrievalOptions(driver, NeedByDate, RecordsNeededFor);
		request.uploadfiles(driver, filetype);
		request.indexOnlyrequest(driver);
		request.searchCreatedRequest(driver);

	}

	@AfterTest
	public void browserclose() {
		driver.close();
	}

}
