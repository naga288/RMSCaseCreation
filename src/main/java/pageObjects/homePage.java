package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	public WebDriver driver;
	
	public homePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//private String element = "//div[@class='topblue']/span[contains(text(),'PATIENT DEMOGRAPHICS')]";

	@FindBy(xpath="//a[contains(@id,'Dashboard')]")
	WebElement dashboardbutton;
	
	@FindBy(xpath="//div[@class='UserName']//span[contains(@id,'Name')]")
	WebElement username;
	
	@FindBy(xpath="//div[contains(@id,'RecordsTabPage')]") WebElement RecordsTabPage;
	@FindBy(xpath="//a[contains(text(),' Add New Patient')]")
	WebElement addpatient;
	@FindBy(xpath="//input[contains(@id,'PatientSearch')]") WebElement PatientSearch;
	@FindBy(xpath="//a[contains(text(),'Search')]") WebElement Search;
	@FindBy(xpath="//tr[contains(@id,'rgResults')]/td/a") List<WebElement> SearchResults;
	
	@FindBy(xpath="//div[@class='UserIcon']")
	WebElement UserIcon;

	@FindBy(linkText="Logout")
	WebElement Logout;
	public WebElement username() {
		return username;
	}

	public WebElement dashboardbutton() {
		return dashboardbutton;
	}

	public WebElement addpatient() {
		return addpatient;
	}

	public WebElement UserIcon() {
		return UserIcon;
	}
	
	public WebElement RecordsTabPage() {
		return RecordsTabPage;
	}
	public WebElement PatientSearch() {
		return PatientSearch;
	}
	public WebElement Search() {
		return Search;
	}
	public List<WebElement> SearchResults() {
		return SearchResults;
	}
	public WebElement Logout() {
		return Logout;
	}
}