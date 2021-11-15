package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientProfilePage {
	public  WebDriver driver;
	public String element= "//div[@class='topblue']/span[contains(text(),'PATIENT DEMOGRAPHICS')]";
	
	@FindBy(xpath="//div[@class='topblue']/span[contains(text(),'PATIENT DEMOGRAPHICS')]") WebElement demographics;
	@FindBy(xpath="//div[contains(text(),'First Name')]/following::input") WebElement firstname;
	@FindBy(xpath="//div[contains(text(),'Last Name')]/following::input") WebElement lastname;
	@FindBy(id="MainContent_cphAuth_btnPatientNext") WebElement checkextPatient;
	@FindBy(xpath="//div/h3[contains(text(),'Patient Reconciliation')]") WebElement PatientReconciliation;
	@FindBy(xpath="//a[contains(@id, 'PatientReconciliation1_btnCreate')]") WebElement createpatient;
	@FindBy(css="div[class='topblue']") WebElement newpatient;
	
	@FindBy(xpath="//input[contains(@id,'SSN')]") WebElement SSN;
	@FindBy(xpath="//input[contains(@id,'rdpDOB_dateInput')]") WebElement DOB;
	@FindBy(xpath="//input[@id[substring(.,string-length(.) - string-length('txtAdd1') + 1) = 'txtAdd1']]") WebElement Street1;
	@FindBy(xpath="//span[contains(@id,'txtCity_wrapper')]/input[@type='text']") WebElement city;
	@FindBy(xpath="//select[contains(@id,'ddlState')]") WebElement state;
	@FindBy(xpath="//input[contains(@id,'txtPostal')]") WebElement postalcode;
	@FindBy(xpath="//input[contains(@id,'txtPhone')]") WebElement phonenumber;
	@FindBy(xpath="//select[contains(@id,'ddlDepartment')]") WebElement department;
	@FindBy(css="button[value='Next']") WebElement next;
	@FindBy(xpath="//div[contains(@id,'Panel1')]//span[@style='display: inline;']") List<WebElement> errors;
	@FindBy(id="retrievalOptions") WebElement retrievalOptionsScreen;
	public patientProfilePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement retrievalOptionsScreen() {
		return retrievalOptionsScreen;
	}
	
	public List<WebElement> errors() {
		return errors;
	}

	public WebElement next() {
		return next;
	}
	
	public WebElement phonenumber() {
		return phonenumber;
	}

	public WebElement department() {
		return department;
	}	
	public WebElement demographics() {
		return demographics;
	}
	public WebElement firstname() {
		return firstname;
	}
	
	public WebElement lastname() {
		return lastname;
	}
	public WebElement checkextPatient() {
		return checkextPatient;
	}
	public WebElement PatientReconciliation() {
		return PatientReconciliation;
	}
	public WebElement createpatient() {
		return createpatient;
	}
	public WebElement newpatient() {
		return newpatient;
	}
	public WebElement SSN() {
		return SSN;
	}
	public WebElement DOB() {
		return DOB;
	}
	public WebElement Street1() {
		return Street1;
	}
	public WebElement city() {
		return city;
	}
	public WebElement state() {
		return state;
	}
	public WebElement postalcode() {
		return postalcode;
	}


}
