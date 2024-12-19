package seleniumtrickyqns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Pseudo Elements - these are abstract elements  in CSS
 * Allow you to style specific parts of the element without  adding extra HTML
 * Examples of pseudo elements
 * ::before
 * ::after
 * ::first-line
 * ::selection
 * ::has
 * these are used to represent the *(mandatory fields) 
 */


public class FindingMandatoryFields_PsuedoElements {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/en-gb?route=account/register");
		driver.manage().window().maximize();

		List<WebElement> elements= driver.findElements(By.xpath("//form[@id='form-register']//label"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		for(WebElement element:elements)
		{
			String script = "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')";
			String content=js.executeScript(script, element).toString();
			
			if(content.contains("*"))
			{
				System.out.println(element.getText()+"Mandatory Field");
			}
			else
			{
				System.out.println(element.getText()+"Not a Mandatory Field");
			}
			
		}
		driver.quit();
	}

}
