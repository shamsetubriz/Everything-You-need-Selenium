package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	
	//Leaving space between lines of code is a poor practice but I have left spaces 
	//in purpose for easier readability and clarity. Leaving space is waste of memory.
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
		driver. get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.cssSelector("#draggable")))
		.moveToElement(driver.findElement(By.cssSelector("#droppable")))
		.release().build().perform();

	}

}
