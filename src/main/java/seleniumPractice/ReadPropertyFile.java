package seleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropertyFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Properties prop = new Properties();
		
		FileInputStream fi = new FileInputStream("/Users/shams/eclipse-workspace/"
				+ "EverythingYouNeed-Selenium/src/main/java/seleniumPractice/config.properties");
		prop.load(fi);

		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		
		String url = prop.getProperty("URL");
		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		/*else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/geckodriver");
			driver = new FirefoxDriver();	
		}*/
		/*else if(browserName.equals("ie")){
			System.setProperty("webdriver.ie.driver", "../Generic/browser-driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }*/
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().fullscreen();
		
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).clear();
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstName"));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).clear();
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastname"));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).clear();
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).clear();
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		Thread.sleep(3000);
		
		driver.quit();
				
	}

}
