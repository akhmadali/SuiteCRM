package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	private WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="CREATE")
	public WebElement create;
	
	// hover over menu
	public void createNewItem(String itemType) {
		Actions action = new Actions(driver);
		action.moveToElement(create).perform();
		driver.findElement(By.linkText(itemType)).click();
	}
}
