package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FaceBookPage {
	WebDriver driver;

	public FaceBookPage(WebDriver driver) {

		this.driver = driver;

	}

	By userNameFeild = By.xpath("//input[@name='email']");
	By passwordFeild = By.xpath("//input[@name='pass']");
	By loginBtn = By.xpath("//button[@type='submit']");

	public void enterUserName() {

		driver.findElement(userNameFeild).sendKeys("TestUser");
	}

	public void enterPassword() {

		driver.findElement(passwordFeild).sendKeys("1234");

	}

	public void verifyLoging() {
		driver.findElement(loginBtn).click();

		String title = driver.getTitle();
		Assert.assertEquals(title, "Login page");
	}
}
