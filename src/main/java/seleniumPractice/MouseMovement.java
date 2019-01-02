package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {
	//Leaving space between lines of code is a poor practice but I have left spaces 
	//in purpose for easier readability and clarity. Leaving space is waste of memory.
	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.spicejet.com/");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='highlight-addons']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Priority Check-in")).click();
		
	}

}
