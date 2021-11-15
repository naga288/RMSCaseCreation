package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientDigestPage {
public WebDriver driver;
public patientDigestPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//div[contains(@id,'IntakeGrid_rgRecords')]") WebElement intakerecords;
	@FindBy(xpath="//div[contains(@id,'IntakeGrid_rgRecords')]//h5/small") WebElement casetext;
	
	
	
	public WebElement getintakerecords() {
		return intakerecords;
	}
	public WebElement getcasetext() {
		return casetext;
	}
	
}
