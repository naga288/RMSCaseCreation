package Casecreation.RMS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RMSV2.RMSCustomerPortal.RMS_access_methods;
import resources.ProviderRequestExcelDataProvider;
import resources.driverClass;

public class RMS_Login_out extends driverClass {
	public static WebDriver driver;
	
	@BeforeTest
	public void initialise() throws Exception {
		driver=intializedriver();
		
	}
	@Test(priority = 1,dataProvider = "RMSAccess", dataProviderClass = ProviderRequestExcelDataProvider.class)
	public void login(String Env,String UserName,String Password) throws IOException, InterruptedException {
		RMS_access_methods signin = new RMS_access_methods();
		signin.login(driver,Env, UserName, Password);

	}
	
	@Test(priority=2)
	public void logout() throws InterruptedException {
		RMS_access_methods signout=new RMS_access_methods();
		signout.logout(driver);
		
	}
	
	@AfterTest
	public void browserclose() {
		driver.close();
	}

}
