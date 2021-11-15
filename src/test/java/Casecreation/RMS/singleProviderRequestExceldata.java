package Casecreation.RMS;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RMSV2.RMSCustomerPortal.ProviderRequestMethods2;
import RMSV2.RMSCustomerPortal.RMS_access_methods;
import RMSV2.RMSCustomerPortal.RMS_request_methods2;
import resources.ProviderRequestExcelDataProvider;
import resources.driverClass;


public class singleProviderRequestExceldata extends driverClass {
	public static WebDriver driver;
	RMS_request_methods2 request = new RMS_request_methods2();
	ProviderRequestMethods2 Provider_request = new ProviderRequestMethods2();

//public static Logger log=LogManager.getLogger("INdexOnlyRequest");

	@BeforeTest
	public void browser() throws Exception {
		driver = intializedriver();
	
	}

	@Test(priority = 1,dataProvider = "RMSAccess", dataProviderClass = ProviderRequestExcelDataProvider.class)
	public void login(String Env,String UserName,String Password) throws IOException, InterruptedException {
		RMS_access_methods signin = new RMS_access_methods();
		signin.login(driver,Env, UserName, Password);

	}

	@Test(dataProvider = "ExcelData", dataProviderClass = ProviderRequestExcelDataProvider.class, dependsOnMethods = { "login" })
	public void ProviderRequest(String NeedByDate, String AuthorizingPhysician,
			String IndexRequest, String filetype,String facilityName,String provider_state, String Provider_city, String rec_template,String img_template, String path_template) throws InterruptedException, IOException {
		request.patientdemographics(driver);
		request.chooseRetrievalOptions(driver, NeedByDate, AuthorizingPhysician);
		if(IndexRequest.equalsIgnoreCase("Yes")) {
			request.uploadfiles(driver, filetype);
		}else {
		request.uploadfilesNext(driver);}
		
		Provider_request.singleLocationProvider(driver, facilityName, provider_state, Provider_city, rec_template, img_template, path_template);
		request.searchCreatedRequest(driver);

	}

	
@AfterTest
	public void browserclose() {
		driver.close();
	}

}
