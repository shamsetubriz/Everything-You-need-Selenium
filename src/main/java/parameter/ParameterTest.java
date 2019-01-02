package parameter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"browser", "url","userId","password"})
	public void twitterLoginTest(String browser, String url, String userId, String password) {
		
		if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
		driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/shams/Downloads/geckodriver");
			driver = new FirefoxDriver();	
		}
		
		driver.get(url);
		
		driver.findElement(By.name("session[username_or_email]")).clear();
		driver.findElement(By.name("session[username_or_email]")).sendKeys(userId, Keys.ENTER);
		//driver.findElement(By.name("session[password]")).clear();
		//driver.findElement(By.name("session[password]")).sendKeys(password, Keys.ENTER);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
			
	}

}
