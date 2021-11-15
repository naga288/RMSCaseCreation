package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class confirmationPage {
	@FindBy(className = "footer")
	WebElement Footer;
	@FindBy(linkText = "Done")
	WebElement Done;

	public WebElement getFooter() {
		return Footer;
	}
	public WebElement getDone() {
		return Done;
	}
}
