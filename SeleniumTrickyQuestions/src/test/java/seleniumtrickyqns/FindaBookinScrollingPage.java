package seleniumtrickyqns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindaBookinScrollingPage {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://booksbykilo.in/new-books");
		driver.manage().window().maximize();

		//1. We can Scroll page using Actions Class
	/*	Actions action=new Actions(driver);
		
		WebElement book = driver.findElement(By.xpath("//h3[normalize-space()='Twinkle Twinkle Little Star']"));
		action.scrollToElement(book).perform();
		//we got no such element exception, due to infinite scrolling on the webpage - failed*/
		
		//2 we can try using JavascriptExecutor
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement book = driver.findElement(By.xpath("//h3[normalize-space()='Twinkle Twinkle Little Star']"));
		js.executeScript("arguments[0].scrollIntoView()", book);
		//we got no such element exception, due to infinite scrolling on the webpage - failed*/
		
		//3.lets try some logic
		JavascriptExecutor js = (JavascriptExecutor)driver;
		boolean found =false;
		while(!found)
		{
			List<WebElement> books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3")); // parent tag of all the book tags
			for(WebElement book:books) 
			{
				if(book.getText().equals("Twinkle Twinkle Little Star"))	
				{
					System.out.println("Book Found!");
					found=true;
					break;
				}
			}
			js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

		}
		driver.quit();
		
		
}
}