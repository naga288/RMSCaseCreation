package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class providersPage {
	public WebDriver driver;
	public providersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "input[value='Recent Providers List']")
	WebElement RecentProviders;

	@FindBy(xpath = "//button[contains(@class,'k-switch-off')]")
	WebElement IndexToggleOff;

	@FindBy(xpath = "//button[contains(@name,'IndexOnlySwitch')]")
	WebElement IndexOnlySwitch;

	@FindBy(xpath = "//button[contains(@class,'k-switch-on')]")
	WebElement IndexToggleOn;

	@FindBy(xpath = "//button[contains(@name,'IndexOnlySwitch')]/following-sibling::label")
	WebElement IndexOnlySwitchLabel;

	@FindBy(xpath = "//a[contains(@id,'btnSubmit')]")
	WebElement Submit_Next;
	
	@FindBy(xpath="//div[contains(@id,'RecentProvidersList')]//tbody/tr[contains(@id,'RecentProvidersList')]") WebElement RecentProvidersList;
	@FindBy(xpath="//div[contains(@id,'RecentProvidersList')]//tbody/tr[contains(@id,'RecentProvidersList')]/td/a") List<WebElement> RecentProvidersName;
	@FindBy(css="a[class=rwCloseButton]") WebElement close;
	
	@FindBy(xpath="//input[@name='providerName']") WebElement ProviderNameField;
	@FindBy(xpath="//input[@name='city']") WebElement city;	
	
	
@FindBy(xpath="//select[@name='providerState']") WebElement StateDropDown;

@FindBy(xpath="//i[@id='SearchIcon']/..") WebElement Search;

@FindBy(xpath="//div[@class='results-content']") WebElement results;
@FindBy(xpath="//div[@class='providers-grid']//div/table[@role='grid']//tr/td/a") List<WebElement> providerResults;
@FindBy(xpath="//a[contains(text(),'Manage Templates')]") WebElement ManageTemplates;
@FindBy(xpath="//table[contains(@id,'rgProviders')]/tbody/tr") List<WebElement> SelectedProviders;
@FindBy(xpath="//a[contains(@id,'btnSubmit')]") WebElement NextButton;


public WebElement NextButton() {
	return NextButton;
}

public WebElement ManageTemplates() {
	return ManageTemplates;
}
public List<WebElement> getSelectedProviders() {
	return SelectedProviders;
}

public List<WebElement> getRecentProvidersName() {
	return RecentProvidersName;
}

public List<WebElement> getproviderResults() {
	return providerResults;
}

public WebElement getresults() {
	return results;
}

public WebElement getSearch() {
	return Search;
}
	

public WebElement getStateDropDown() {
	return StateDropDown;
}

	public WebElement getcity() {
		return city;
	}

	public WebElement getProviderNameField() {
		return ProviderNameField;
	}

	public WebElement getclose() {
		return close;
	}
	

	public WebElement getRecentProvidersList() {
		return RecentProvidersList;
	}
	
	public WebElement getRecentProviders() {
		return RecentProviders;
	}
	public WebElement getIndexToggleOff() {
		return IndexToggleOff;
	}
	public WebElement getIndexOnlySwitch() {
		return IndexOnlySwitch;
	}
	public WebElement getIndexToggleOn() {
		return IndexToggleOn;
	}
	public WebElement getIndexOnlySwitchLabel() {
		return IndexOnlySwitchLabel;
	}
	public previewPage getSubmit_Next() {
		Submit_Next.click();
		return new previewPage(driver);
	}

}
