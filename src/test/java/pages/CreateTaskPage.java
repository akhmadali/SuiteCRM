package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTaskPage {

	private WebDriver driver;

	public CreateTaskPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	public WebElement subject;
	
	public WebElement status;
	
	public WebElement description;
	
	@FindBy(xpath="//input[@value='Save']")
	public WebElement save;
}
