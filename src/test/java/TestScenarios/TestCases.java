package TestScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.FaceBookPage;
import Objects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
	WebDriver driver;
	GoogleSearchPage objGoogleSearch;

	@BeforeTest
	public void setup() {

		WebDriverManager.edgedriver().setup();// beacause i used webdrivermanager dependency so i dont need to write
												// webdriver path

		driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
	}

	@Test(priority = 0)
	public void searchOperations() throws InterruptedException {
		GoogleSearchPage page = new GoogleSearchPage(driver);// create object from google search page class
		page.searchGoogle("facebook");

	}

	@Test
	public void verifyAndAccessFacebook() {
		objGoogleSearch = new GoogleSearchPage(driver);
		objGoogleSearch.clickOnFacebookLink();

	}

	@Test
	public void verifyLogin() {

		FaceBookPage objFacebookPage = new FaceBookPage(driver);
		objFacebookPage.enterUserName();
		objFacebookPage.enterPassword();
		objFacebookPage.verifyLoging();

	}

	@AfterTest
	public void clear() {
		driver.quit();

	}
}
