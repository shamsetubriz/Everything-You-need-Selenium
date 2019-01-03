package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CustomXpath {

	// Leaving space between lines of code is a poor practice but I have left spaces
	// in purpose for easier readability and clarity. Leaving space is waste of
	// memory.
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

		driver.get("http://www.half.ebay.com");
		// driver.switchTo().frame(0);
		// absolute xpath: not recommended
		// *[@id='headersearchbar']/div/div[2]/table/tbody/tr/td[2]/input
		// 1. performance issue
		// 2. not reliable
		// 3. can be changed at any time in future

		// driver.findElement(By.xpath("//input[@class='actextbox']")).sendKeys("Java");
		// driver.findElement(By.xpath("//input[@name='query']")).sendKeys("Java");

		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mouse trap");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[contains(@class,'gh-tb')]")).sendKeys("java");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.navigate().to("http://www.half.ebay.com");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Electronics"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();

		// driver.findElement(By.xpath("//a[contains(text(),'Electronics')]"));

		// dynamic id: input
		// id = test_123
		// By.id("test_123")

		// starts-with
		// id = test_456
		// id = test_789
		// id = test_test_7890_test

		// ends-with
		// id = 1234_test_t
		// id = 23456_test_t
		// id = 6789_test_t

		// driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Test");
		// driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Test");
		// driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("Test");

		// for links: custom xpath:
		// all the links are represented by <a> html tag:
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
	}

}
