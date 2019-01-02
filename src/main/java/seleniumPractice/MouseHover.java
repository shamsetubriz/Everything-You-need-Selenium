package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.freecrm.com");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("shamsmuhammad");;
		driver.findElement(By.name("password")).sendKeys("dhaka123");;
		 //login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginButton);	
        Thread.sleep(2000);
		//create a few new contacts
		driver.switchTo().frame("mainpanel");		
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("Tofael ");
		driver.findElement(By.id("surname")).clear();
		driver.findElement(By.id("surname")).sendKeys("Kobir");
		driver.findElement(By.name("client_lookup")).clear();
		driver.findElement(By.name("client_lookup")).sendKeys("LabCorp");
		driver.findElement(By.id("department")).clear();
		driver.findElement(By.id("department")).sendKeys("QA");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();;
			
	}

}
