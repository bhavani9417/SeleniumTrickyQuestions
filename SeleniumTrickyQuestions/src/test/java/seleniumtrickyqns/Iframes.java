package seleniumtrickyqns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Iframes {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		 WebElement we=driver.findElement(By.xpath("//frame[contains(@src,'frame_1.html')]"));
		//1. we can handle iframes using switchTo().frame(by passing frame name/id/index/webelement)
			
		 driver.switchTo().frame(we);
		  
		  driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Testing");
		  System.out.println("Test Passed");
		 
		
		//2. We can handle Iframes using Explicit Wait also
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
		mywait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(we));
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Testing");
		 System.out.println("Test Passed");
		
		driver.quit();
		

	}

}
