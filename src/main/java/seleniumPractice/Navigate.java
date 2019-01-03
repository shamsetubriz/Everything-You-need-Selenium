package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {
	// Leaving space between lines of code is a poor practice but I have left spaces
	// in purpose for easier readability and clarity. Leaving space is waste of
	// memory.
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch the browser
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		// driver.get() is used to launch a url.
		driver.get("http://www.amazon.com");

		// driver.navigate().to() is used to launch some other extarnel url
		driver.navigate().to("http://www.facebook.com");

		// back and forward button simulation
		driver.navigate().back();

		Thread.sleep(2000);

		driver.navigate().forward();

		Thread.sleep(2000);

		driver.navigate().back();

		driver.navigate().refresh();

	}

}
