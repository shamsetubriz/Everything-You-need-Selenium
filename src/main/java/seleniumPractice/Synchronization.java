package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {
	// Leaving space between lines of code is a poor practice but I have left spaces
	// in purpose for easier readability and clarity. Leaving space is waste of
	// memory.
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// 1. ImplicitelyWait is always applied globally -- is available for all the
		// WebElements.
		// 2. Dynamic in nature
		// 3. It can be changed any where and anytime in the code.

		driver.get("https://www.freecrm.com");

		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

		sendKeys(driver, username, 5, "shamsmuhammad");
		sendKeys(driver, password, 5, "dhaka123");
		clickOn(driver, loginButton, 5);

		driver.quit();
	}

	// Explicit wait:
	// 1. No Explicit keyword
	// 2. Available with the form of WebDriverWait with some ExpectedConditions.
	// 3. Specific to element
	// 4. Dynamic in nature

	// These two method I have created to use it for every time I am going to use
	// explicitly wait. Whenever
	// explicitly wait is needed, I can call this two method to perform explicitly
	// wait without writing three
	// lines of code
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
