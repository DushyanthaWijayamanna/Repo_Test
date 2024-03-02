package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
	WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {

		this.driver = driver;

	}

	By searchBox = By.xpath("//div[@jsname='vdLsw']/following-sibling::textarea");
	By searchBtn = By.xpath("(//input[@value='Google Search' and @type='submit'])[1]");
	By faceBookLink = By.xpath("//a[@jsname='UWckNb']/h3[text()='Facebook - log in or sign up']");

	public void searchGoogle(String searchInput) {

		try {
			driver.findElement(searchBox).sendKeys(searchInput);
			driver.findElement(searchBtn).click();
			Thread.sleep(2000);
		} catch (Exception e) {

			System.out.println("Exception" + e.getMessage());
		}

	}

	public void clickOnFacebookLink() {

		try {
			driver.findElement(faceBookLink).click();
			Thread.sleep(2000);
		} catch (Exception e) {

			System.out.println("Exception" + e.getMessage());
		}

	}
}
