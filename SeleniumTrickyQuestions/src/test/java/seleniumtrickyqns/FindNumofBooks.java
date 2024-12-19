package seleniumtrickyqns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FindNumofBooks {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://booksbykilo.in/new-books");
		driver.manage().window().maximize();
		
		//1.using size() method
		/*List<WebElement> books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3")); // parent tag of all the book tags
		System.out.println("Number of Books:" +books.size());//20 - but we have around 140+ books- its failed*/
		
		//2 using javascriptExecutor
		/*JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		List<WebElement> books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3")); // parent tag of all the book tags
		System.out.println("Number of Books:" +books.size());//20 - but we have around 140+ books- its failed*/
		
		//logic
		//JavascriptExecutor js =(JavascriptExecutor)driver;
		Actions act = new Actions(driver);
		int previouscount =0;
		int currentcount=0;
		
		while(true)
		{
			List<WebElement> books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3")); // parent tag of all the book tags
			currentcount=books.size();
			
			if(currentcount==previouscount)
			{
				break;
			}
			previouscount=currentcount;
			//js.executeScript("window.scrollBy(0.document.body.scrollHeight)");
			act.sendKeys(Keys.END).perform();
			Thread.sleep(5000);
			
		}
		
		System.out.println("The number of books: " +currentcount);
		
	}

}
