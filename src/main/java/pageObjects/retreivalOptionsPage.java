package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class retreivalOptionsPage {
	public WebDriver driver;
	public retreivalOptionsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//div[contains(text(),'CHOOSE RETRIEVAL OPTIONS')]") WebElement CHOOSERETRIEVALOPTIONS;

	@FindBy(xpath = "//input[contains(@id,'ReqNeedByDate_dateInput')][@type='text']")
	WebElement NeedByDate;

	@FindBy(xpath = "//select[contains(@id,'NeededFor')]")
	WebElement NeedFor;

	@FindBy(xpath = "//input[contains(@id,'txtAuth')]")
	WebElement AuthPhy_txt;
	
	@FindBy(xpath="//select[contains(@id,'AuthPhysician')]") WebElement AuthPhy_selector;

	@FindBy(xpath = "//select[contains(@id,'PurposeofRequest')]")
	WebElement PurposeOfRequest;

	@FindBy(xpath = "//a[contains(@id,'btnNext')]")
	WebElement Next;

	@FindBy(css = "div[id='retrievalOptions'] div[class='required'] span")
	List<WebElement> Errelements;



	public WebElement AuthPhy_selector() {
		return AuthPhy_selector;
	}
	
	

	public WebElement CHOOSERETRIEVALOPTIONS() {
		return CHOOSERETRIEVALOPTIONS;
	}

	public WebElement getNeedByDate() {
		return NeedByDate;
	}
	public WebElement NeedFor() {
		return NeedFor;
	}
	public WebElement AuthPhy_txt() {
		return AuthPhy_txt;
	}
	public WebElement PurposeOfRequest() {
		return PurposeOfRequest;
	}
	public uploadFilesPage Next() {
		Next.click();
		return new uploadFilesPage(driver);
	}
	public List<WebElement> Errelements() {
		return Errelements;
	}

}
