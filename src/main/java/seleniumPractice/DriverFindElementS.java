package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFindElementS {
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

		driver.get("http://www.half.ebay.com");

		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());

		for (int i = 0; i < linkList.size(); i++) {
			String linjText = linkList.get(i).getText();
			System.out.println(linjText);
		}
	}
}
