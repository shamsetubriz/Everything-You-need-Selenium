package seleniumPractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	//Leaving space between lines of code is a poor practice but I have left spaces 
	//in purpose for easier readability and clarity. Leaving space is waste of memory.
	public static void mail() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		driver. get("http://www.facebook.com");				
	}
}
