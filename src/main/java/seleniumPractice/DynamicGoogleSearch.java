package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleSearch {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("testing");
		
		//we need to use the findElements() method because we have to get the entire list of suggestion. 
		//Use the descendant function to create the custom xpath becase we need to get all the children of <li tag 
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));
		
		System.out.println("Total number of suggestion on the search bos is: " + list.size());
		
		
		//after creating the list, we need to iterate the list and look for the particular text.as soon as it is found 
		//we click on it and break out of the loop because we do not want to look in to every single search suggestion.
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("testing 1 2 3")) {
				list.get(i).click();
				break;
			}
		}

	}

}
