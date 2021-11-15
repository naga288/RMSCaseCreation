package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class driverClass {
	public  WebDriver driver;
	public Properties prop;
	public static String userdir=System.getProperty("user.dir");

	public WebDriver intializedriver() throws IOException, Exception {

		 prop = new Properties();
		FileInputStream fis = new FileInputStream(userdir+
				"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		//String browserName=System.getProperty("browser");
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", userdir+"\\src\\main\\java\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", userdir+"\\src\\main\\java\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		}else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", userdir+"\\src\\main\\java\\Resources\\msedgedriver.exe");
			driver = new EdgeDriver();

		}else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", userdir+"\\src\\main\\java\\Resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}



		/*
		 * else if (browserName=="IE") {
		 * 
		 * }
		 */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile=userdir+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src, new File(
	destinationFile));
		return destinationFile;

	}

}
