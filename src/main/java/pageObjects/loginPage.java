package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	public WebDriver driver;
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[@class='login-graphic']")
	WebElement loginscreen;
	
	@FindBy(xpath="//input[contains(@id,'UserName')]")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(id="MainContent_Login1_LoginButton")
	WebElement signin;
	
	@FindBy(xpath="//div[contains(text(),'Your login was unsuccessful. Please try again')]")
	WebElement  login_errmsg;
	
	
	public WebElement loginScreen() {
		
		return loginscreen;
	
	}

	public WebElement username() {
		return username;
	
	}
	public WebElement password() {
		return password;
	
	}
	public WebElement signin() {
		
	return signin;
	}	

	public WebElement login_errmsg() {
		return login_errmsg;
	
	}	

}


