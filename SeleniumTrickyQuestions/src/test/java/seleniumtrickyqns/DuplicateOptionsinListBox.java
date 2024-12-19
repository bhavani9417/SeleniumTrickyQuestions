package seleniumtrickyqns;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class DuplicateOptionsinListBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement listboxElement=driver.findElement(By.xpath("//select[@id='colors']"));
		Select listbox = new Select(listboxElement);
		
		Set<String> uniqueOptions = new HashSet<String>();
		
		boolean flag=false;
		
		for(WebElement options:listbox.getOptions())
		{
			String Optionstext=options.getText();
			if(!uniqueOptions.add(Optionstext))// suppose if(uniqueOptions.add(Optionstext))- the text already exists in the set it will return false, so if(!uniqueOptions.add(Optionstext)) - so, now if the text already exists in the set it will return true
			{
			System.out.println("Duplicates Found: "+Optionstext);	
			flag=true;
			}
			
		}
		if(!flag)
		{
			System.out.println("No duplicates were found");
		}
		driver.quit();
		
	}

}
