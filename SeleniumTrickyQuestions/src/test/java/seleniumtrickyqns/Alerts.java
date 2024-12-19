package seleniumtrickyqns;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		
		Thread.sleep(5000);
		//1. We can Handle using Alert Interface
		/*Alert is an Interface, driver.switchTo() method returns alert type of object
		 * 
		 */
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		//alert.accept();
		
			
		//2. we can also handle alert using Explicit Wait
			
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert1=mywait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert1.getText());
		
		alert1.accept();
		
		//3. we can handle alert using JavaScriptExecutor also
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
		js.executeScript("window.alert=function{};");// this will automatically close our alert box
		}
		catch(Exception e){
			
		}
		driver.quit();
		
		

	}

}
