package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class templatePage {
	
	public WebDriver driver;
	public templatePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//select[contains(@id,'RecordTemplate')]") WebElement RecTemplateOptions;
	
	@FindBy(xpath="//select[contains(@id,'ImagesTemplate')]") WebElement ImgTemplateOptions;
	
	@FindBy(xpath="//select[contains(@id,'PathologyTemplates')]") WebElement PathTemplateOptions;
	
	@FindBy(xpath="//textarea[contains(@name,'txtExplanation')]") WebElement notesarea;
	
	@FindBy(xpath="//a[contains(@id,'btnNext')]") WebElement NextButton;
	
	@FindBy(xpath="//button[@data-validation-group='ChooseRecordTemplate']") WebElement ApplyRecordsTemlate;
	@FindBy(xpath="//ul[@class='rlbList']/li[contains(@id,'Records')]") List<WebElement> RecordItems;
	@FindBy(xpath="//div[@class='footer']") WebElement footer;
	
	@FindBy(xpath="//button[@data-validation-group='ChooseImagesTemplate']") WebElement ApplyImagesTemlate;
	@FindBy(xpath="//ul[@class='rlbList']/li[contains(@id,'Images')]") List<WebElement> ImageItems;
	@FindBy(xpath="//button[@data-validation-group='ChoosePathTemplate']") WebElement ApplyPathologyTemlate;
	@FindBy(xpath="//ul[@class='rlbList']/li[contains(@id,'Pathology')]") List<WebElement> PathologyItems;
	
	public WebElement footer() {
		return footer;
	}
	public List<WebElement> getImageItems() {
		return ImageItems;
	}
	
	public WebElement ApplyImagesTemlate() {
		return ApplyImagesTemlate;
	}
	public List<WebElement> getPathologyItems() {
		return PathologyItems;
	}
	
	public WebElement ApplyPathologyTemlate() {
		return ApplyPathologyTemlate;
	}
	
	public List<WebElement> getRecordItems() {
		return RecordItems;
	}
	
	public WebElement ApplyRecordsTemlate() {
		return ApplyRecordsTemlate;
	}
	
	public WebElement RecTemplateOptions() {
		return RecTemplateOptions;
	}
	public WebElement ImgTemplateOptions() {
		return ImgTemplateOptions;
	}
	public WebElement PathTemplateOptions() {
		return PathTemplateOptions;
	}
	public WebElement notesarea() {
		return notesarea;
	}
	public WebElement NextButton() {
		return NextButton;
	}

	
}
