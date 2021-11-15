package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class previewPage {
	public WebDriver driver;
	@FindBy(className = "footer")
	WebElement Footer;

	@FindBy(xpath = "//a[contains(text(),'Submit Request ')]")
	WebElement SubmitRequest;
	
	@FindBy(linkText="Done") WebElement done;
	
	public previewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getFooter() {
		return Footer;
	}
	public WebElement getSubmitRequest() {
		return SubmitRequest;
	}
	public WebElement getDone() {
		return done;
	}
}
