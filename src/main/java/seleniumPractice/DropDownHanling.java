package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHanling {
	// Leaving space between lines of code is a poor practice but I have left spaces
	// in purpose for easier readability and clarity. Leaving space is waste of
	// memory.
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

		driver.get("http://www.facebook.com");

		Select select = new Select(driver.findElement(By.id("month")));
		select.selectByIndex(1);

		Select select1 = new Select(driver.findElement(By.id("day")));
		select1.selectByVisibleText("4");

		Select select2 = new Select(driver.findElement(By.id("year")));
		select2.selectByVisibleText("1981");

	}

}
