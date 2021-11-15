package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class uploadFilesPage {
	public WebDriver driver;
	@FindBy(xpath = "//div[contains(text(), 'Select file type to upload')]")
	WebElement UploadFilesScreen;
	@FindBy(xpath = "//input[@value='Select']/parent::span")
	WebElement Dropdown;
	@FindBy(xpath = "//div[contains(@id,'FileType_DropDown')]//ul/li")
	List<WebElement> SelectOptions;

	@FindBy(xpath = "//button[contains(@name,'chkIndexing')]")
	WebElement IndexCheckbox;

	@FindBy(xpath = "//input[contains(@id,'Upload1file0')]/..")
	WebElement UpoadFile;

	@FindBy(xpath = "//button[contains(@name,'chkIndexing')]/span[contains(@class,'ToggleCheckboxChecked')]")
	WebElement IndexEnabled;

	@FindBy(xpath = "//table[@id='dataTable']/tbody/tr/td/a")
	List<WebElement> UploadedReports;

	@FindBy(xpath = "//a[contains(@id,'btnNext')]")
	WebElement Next;


	
	public uploadFilesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement UploadFilesScreen() {
		return UploadFilesScreen;
	}
	public WebElement getDropdown() {
		return Dropdown;
	}
	public List<WebElement> getSelectOptions() {
		return SelectOptions;
	}
	public WebElement getIndexCheckbox() {
		return IndexCheckbox;
	}
	public WebElement getUpoadFile() {
		return UpoadFile;
	}
	public WebElement getIndexEnabled() {
		return IndexEnabled;
	}
	public List<WebElement> getUploadedReports() {
		return UploadedReports;
	}
	public providersPage getNext() {
		Next.click();
		return new providersPage(driver);
	}
}
