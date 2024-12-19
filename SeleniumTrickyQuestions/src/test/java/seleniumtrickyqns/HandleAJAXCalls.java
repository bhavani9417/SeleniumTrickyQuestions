package seleniumtrickyqns;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//AJAX Calls - An AJAX Call is a web development technique, that allows a website to update part of its content without reloading the entire webpage
//AJAX Stands for Asynchronous JavaScript and XML, and it's a collection of technologies that make web applications more responsive for user interaction.
public class HandleAJAXCalls {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='loadContent']")).click();
		
		/*WebElement loadedcontent = driver.findElement(By.xpath("//div[@id='ajaxContent']/h2"));
		System.out.println(loadedcontent.getText());*/
		
		//here its taking some time to display/load the content due to ajax calls - we will get the NosuchElement exception
		//to overcome this we can use Explicit wait
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement loadedcontent= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajaxContent']/h2")));
		System.out.println(loadedcontent.getText());
		
        driver.quit();
	}

}
