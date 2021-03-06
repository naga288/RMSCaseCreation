package RMSV2.RMSCustomerPortal;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageObjects.homePage;
import pageObjects.patientDigestPage;
import pageObjects.patientProfilePage;
import pageObjects.previewPage;
import pageObjects.providersPage;
import pageObjects.retreivalOptionsPage;
import pageObjects.templatePage;
import pageObjects.uploadFilesPage;

public class RMS_request_methods2 {
	public static String first_Name="AutoTest";
	public static String lastName;
	public static String SSN="987654444";
	public static String dob="1/7/1990";
	public static String streetAdd="TestAdd";
	public static String city="New York";
	public static String postalCode="10001";
	public static String phnum="9798798797";
	public static String RecordsNeededFor="Appointment";
	public static String PurposeOfRequest="New Patient Consultation";	
	public static String PatientName;
	public static homePage home_page;
	public static patientProfilePage profile_page;
	public static retreivalOptionsPage retrieval_page;
	public static uploadFilesPage upload_files;
	public static providersPage provider_page;
	public static previewPage preview_page;
	public static patientDigestPage patient_digest;
	public static String userdir = System.getProperty("user.dir");
	public static templatePage temp_page;
	public static resources.waits waits;
	
	
	public String patientdemographics(WebDriver driver,String dept) throws InterruptedException, IOException {
	
		home_page = new homePage(driver);
		retrieval_page = new retreivalOptionsPage(driver);
		profile_page = new patientProfilePage(driver);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1 = dateFormat.format(date);
		lastName = date1;
		first_Name="AutoTest";
		home_page.addpatient().click();
		newpatientblock: while (true) {
			if (profile_page.demographics().isDisplayed()) {
				System.out.println("New patient request tab is opened");
				break newpatientblock;
			} else {
				System.out.println("demographic else loop");
waits.WaitForElement(driver, profile_page.demographics());
				//Thread.sleep(1000);
			}
		}

		System.out.println("Checking for existing  Patient profiles");
		profile_page.firstname().sendKeys(first_Name);
		profile_page.lastname().sendKeys(lastName);
		profile_page.checkextPatient().click();

		Patientdetailsblock: while (true) {
			// String Reconciliation="//div/h3[contains(text(),'Patient Reconciliation')]";
			if (profile_page.PatientReconciliation().isDisplayed()) {
				System.out.println("patient profiles tab is opened");
				break Patientdetailsblock;
			} else {
				System.out.println("PatientReconciliation");
				 waits.WaitForElement(driver, profile_page.PatientReconciliation());
			//	Thread.sleep(1000);
			}
		}
		profile_page.createpatient().click();
		requestblock: while (true) {
			if (profile_page.newpatient().isDisplayed()) {
				System.out.println("Creating a new patient profile");
				break requestblock;
			} else {
				Thread.sleep(1000);
			}
		}

		Thread.sleep(3000);
		profile_page.SSN().click();
		profile_page.SSN().sendKeys(SSN);
		profile_page.DOB().sendKeys(dob);
		profile_page.Street1().sendKeys(streetAdd);
		profile_page.city().sendKeys(city);
		Select patcity = new Select(profile_page.state());
		patcity.selectByVisibleText(city);
		profile_page.postalcode().sendKeys(postalCode);

		profile_page.phonenumber().click();
		profile_page.phonenumber().sendKeys(phnum);

		Select department = new Select(profile_page.department());
		department.selectByVisibleText(dept);
		profile_page.next().click();
		List<WebElement> errelements = profile_page.errors();

		for (int i = 0; i < errelements.size(); i++) {
			if (errelements.get(i).isDisplayed()) {
				System.out.println(errelements.get(i).getText());
			}
		}

		if (errelements.isEmpty()) {
			screen2: while (true) {
				// String retrievalOptions="//*[@id='retrievalOptions']";
				if (retrieval_page.CHOOSERETRIEVALOPTIONS().isDisplayed()) {
					System.out.println(retrieval_page.CHOOSERETRIEVALOPTIONS().getText() + " Screen is displayed");
					break screen2;
				} else {
					System.out.println("retrieval_page.CHOOSERETRIEVALOPTIONS()");
waits.WaitForElement(driver, retrieval_page.CHOOSERETRIEVALOPTIONS());
						}
			}
		}
		return lastName;
	}

	public void chooseRetrievalOptions(WebDriver driver, String NeedByDate, String AuthorizingPhysician ) throws InterruptedException  {

		retrieval_page.getNeedByDate().sendKeys(NeedByDate);

		Select rec_need = new Select(retrieval_page.NeedFor());
		rec_need.selectByVisibleText(RecordsNeededFor);
try {		
if(retrieval_page.AuthPhy_selector().isDisplayed()) {
	System.out.println("selector is displayed");
	Select Auth_phy=new Select(retrieval_page.AuthPhy_selector());
	Auth_phy.selectByVisibleText(AuthorizingPhysician);
}}
catch(NotFoundException e){
	System.out.println("textbox is displayed");
	retrieval_page.AuthPhy_txt().sendKeys(AuthorizingPhysician);
	
}


		Select Purpose_Of_Request = new Select(retrieval_page.PurposeOfRequest());
		Purpose_Of_Request.selectByVisibleText(PurposeOfRequest);

		upload_files = retrieval_page.Next();
		List<WebElement> errelements = retrieval_page.Errelements();

		for (int i = 0; i < errelements.size(); i++) {
			if (errelements.get(i).isDisplayed()) {
				System.out.println(errelements.get(i).getText());
			}
		}

		if (errelements.isEmpty()) {
			uploadFiles: while (true) {
				if (upload_files.UploadFilesScreen().isDisplayed()) {
					System.out.println("Retreival options are set and user can upload the files in next screen ");
					break uploadFiles;
				} else {
//					Thread.sleep(1000);
					waits.WaitForElement(driver, upload_files.UploadFilesScreen());
				}
			}

		}
	}

	public void uploadfiles(WebDriver driver, String filetype) throws InterruptedException, IOException {
		upload_files.getDropdown().click();
		List<WebElement> options = upload_files.getSelectOptions();
		for (WebElement option : options) {
			// System.out.println(option.getText());
			if (option.getText().equals(filetype)) {
				option.click(); // click the desired option
				break;
			} else {
Thread.sleep(1000);
			}
		}

//waits.WaitForElement(driver, upload_files.getIndexCheckbox());
		Assert.assertFalse(upload_files.getIndexCheckbox().isSelected());

		upload_files.getUpoadFile().click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec(userdir + "\\src\\main\\java\\Resources\\Autoit\\fileuploadscript.exe");

		Fileupload: while (true) {
			int count = upload_files.getUploadedReports().size();
			if (count > 0) {

				List<WebElement> rprts = upload_files.getUploadedReports();

				System.out.println("No.of reports uploaded : " + rprts.size());
				break Fileupload;
			} else {
				Thread.sleep(1000);
			}
		}

		provider_page = upload_files.getNext();
		providerscreen: while (true) {
			if (provider_page.getRecentProviders().isDisplayed()) {
				System.out.println("Provider screen is displayed");
				break providerscreen;
			} else {
				//Thread.sleep(1000);
				waits.WaitForElement(driver, provider_page.getRecentProviders());
			}
		}

	}

	public void uploadfilesNext(WebDriver driver) throws InterruptedException, IOException {
		provider_page = upload_files.getNext();
		providerscreen: while (true) {
			if (provider_page.getRecentProviders().isDisplayed()) {
				//System.out.println("Provider screen is displayed");
				break providerscreen;
			} else {
			//	Thread.sleep(1000);
				waits.WaitForElement(driver, provider_page.getRecentProviders());
			}
		}

	}

	public void indexOnlyrequest(WebDriver driver) throws InterruptedException {

		System.out.println("Request indexing toggle is off? : " + provider_page.getIndexToggleOff().isDisplayed());

		provider_page.getIndexOnlySwitch().click();

		switchloop: while (true) {

			if (provider_page.getIndexToggleOn().isDisplayed()) {

				System.out.println(provider_page.getIndexOnlySwitchLabel().getText() + " toggle is enabled");
				break switchloop;
			} else {
					waits.WaitForElement(driver, provider_page.getIndexToggleOn());
					}
		}

		preview_page = provider_page.getSubmit_Next();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", preview_page.getFooter());

		submitrequest: while (true) {
			if (preview_page.getSubmitRequest().isDisplayed()) {

				preview_page.getSubmitRequest().click();
				System.out.println("Reports For Indexing request is submitted");
				break submitrequest;
			} else {
				//Thread.sleep(1000);
				waits.WaitForElement(driver, preview_page.getSubmitRequest());
			}
		}

		donerequest: while (true) {
			if (preview_page.getDone().isDisplayed()) {
				preview_page.getDone().click();
				break donerequest;
			} else {
//				Thread.sleep(1000);
				waits.WaitForElement(driver, preview_page.getDone());

			}
		}

		dashboard: while (true) {
			if (home_page.RecordsTabPage().isDisplayed()) {
				System.out.println("Records tab page is displayed");
				break dashboard;
			} else {
				
//				Thread.sleep(1000);
waits.WaitForElement(driver, home_page.RecordsTabPage());
			}
		}

	}
	public String searchCreatedRequest(WebDriver driver) throws InterruptedException {
		PatientName = first_Name + lastName;
		System.out.println("Searching the request");
		dashboard: while (true) {
			if (home_page.RecordsTabPage().isDisplayed()) {
				System.out.println("Dashboard page is displayed");
				break dashboard;
			} else {
				 waits.WaitForElement(driver, home_page.RecordsTabPage());
				System.out.println("Searching the request else loop");
				//Thread.sleep(1000);
			}
		}

		home_page.PatientSearch().sendKeys(lastName);

		home_page.Search().click();
		System.out.println("Searching started");
		List<WebElement> results = home_page.SearchResults();
		System.out.println("Seacrh completed. No.of patient records found: " + results.size());

		for (WebElement res : results) {
			if (res.getText().contains(lastName)) {
				res.click();
			}
		}
		patient_digest = new patientDigestPage(driver);
		patdigest: while (true) {
			if (patient_digest.getintakerecords().isDisplayed()) {
				System.out.println("patient digest page is displayed");

				break patdigest;
			} else {
waits.WaitForElement(driver, patient_digest.getintakerecords());
				//Thread.sleep(1000);
			}
		}
		String casetxt = patient_digest.getcasetext().getText();
		getcase:while(true) {
			if(casetxt.contains("Case")) {
				break getcase;
			}else {
				Thread.sleep(5000);
				driver.navigate().refresh();
				Thread.sleep(2000);			}
		}
		String[] arrSplit = casetxt.split("\\s");
		String casetxt3 = arrSplit[2];
		StringBuffer cno = new StringBuffer(casetxt3);
		// invoking the method
		cno.deleteCharAt(cno.length() - 1);
		// prints the string after deleting the character
		String caseno = cno.toString();
		System.out.println("Case No for "+PatientName+" request is :"+caseno);
		driver.findElement(By.xpath("//a[contains(@id,'Dashboard')]")).click();
		DashboardLoop:while(true) {
			if(home_page.RecordsTabPage().isDisplayed()) {
				break DashboardLoop;
			}else {
				//Thread.sleep(1000);
				waits.WaitForElement(driver, home_page.RecordsTabPage());
			}
		}
		return caseno;
	}

		
	
}
