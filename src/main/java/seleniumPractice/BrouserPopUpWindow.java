package seleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrouserPopUpWindow {

	// Leaving space between lines of code is a poor practice but I have left spaces
	// in purpose for easier readability and clarity. Leaving space is waste of
	// memory.
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

		driver.get("http://popuptest.com/goodpopups.html");

		driver.findElement(By.xpath("//a[@class='black']")).click();
		Thread.sleep(2000);

		// We use getWindowHandles() method to handel the windows
		// this getWindowHandles() return a Set of String object.
		Set<String> handler = driver.getWindowHandles();

		/*
		 * In Set object window/popUp are not stored in the basis of index. So, to get
		 * the values from Set object we have to use the iterator() method this
		 * iterator() will return an Iterator of String
		 */
		Iterator<String> it = handler.iterator();

		String ChieldWindowID = it.next();
		System.out.println(ChieldWindowID);

		String ParentWindowID = it.next();
		System.out.println(ParentWindowID);

		driver.switchTo().window(ChieldWindowID);
		Thread.sleep(2000);
		System.out.println("Title of the chield window is : " + driver.getTitle());
		driver.close();

		driver.switchTo().window(ParentWindowID);
		Thread.sleep(2000);
		System.out.println("Title of the parent window is : " + driver.getTitle());

	}

}
