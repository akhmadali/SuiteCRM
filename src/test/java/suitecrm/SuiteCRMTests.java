package suitecrm;

import static utilities.ConfigReader.getProperty;

import java.time.LocalDateTime;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateTaskPage;
import pages.Homepage;
import pages.LoginPage;
import pages.TaskOverviewPage;

public class SuiteCRMTests extends TestBase{
	LoginPage loginPage;
	Homepage homepage;
	CreateTaskPage createTaskPage;
	TaskOverviewPage taskOverviewPage;
	
	@BeforeMethod
	public void navigate() {
		// navigate to page
		driver.get(getProperty("url"));
		loginPage = new LoginPage(driver);
		homepage = new Homepage(driver);
		createTaskPage = new CreateTaskPage(driver);
		taskOverviewPage = new TaskOverviewPage(driver);
		
	}

	@Test
	public void createTaskInSuiteCRM() {
		loginPage.login(getProperty("username"), getProperty("password"));
		homepage.createNewItem("Create Task");
		createTaskPage.subject.sendKeys(getProperty("subject"));
		new Select(createTaskPage.status).selectByVisibleText(getProperty("status"));
		createTaskPage.description.sendKeys(getProperty("description") + " - " + LocalDateTime.now());
		createTaskPage.save.click();
	}
	
}
