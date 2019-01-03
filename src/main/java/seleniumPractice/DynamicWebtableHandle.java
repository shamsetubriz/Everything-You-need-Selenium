package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicWebtableHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

		driver.get("https://www.freecrm.com");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("shamsmuhammad");
		;
		driver.findElement(By.name("password")).sendKeys("dhaka123");
		;
		// login button
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginButton);
		Thread.sleep(2000);

		driver.switchTo().frame("mainpanel");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		// *[@id="vContactsForm"]/table/tbody/tr[4]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[7]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[8]/td[2]/a

		// We can create custom xpath following way using "forwarding-sibling" and
		// "preceding-sibling" concept, in order to handle dynamic web table.
		driver.findElement(By.xpath(
				"//a[contains(text(),'ayaat shams')]/parent::td//preceding-sibling::td//input[@type='checkbox']"))
				.click();
		boolean b1 = driver.findElement(By.xpath(
				"//a[contains(text(),'ayaat shams')]/parent::td//preceding-sibling::td//input[@type='checkbox']"))
				.isSelected();
		System.out.println("Ayaat's checkbox is selected ==>" + b1);// true

		driver.findElement(By.xpath(
				"//a[contains(text(),'qurrat shams')]//parent::td//preceding-sibling::td//input[@type='checkbox']"))
				.click();
		boolean b2 = driver.findElement(By.xpath(
				"//a[contains(text(),'qurrat shams')]//parent::td//preceding-sibling::td//input[@type='checkbox']"))
				.isSelected();
		System.out.println("Qurrat's checkbox is selected ==>" + b2);// true

	}

}
