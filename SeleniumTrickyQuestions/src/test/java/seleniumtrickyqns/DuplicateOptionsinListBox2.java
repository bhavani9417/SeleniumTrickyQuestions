package seleniumtrickyqns;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateOptionsinListBox2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Select listbox= new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		Set <String> uniquelistoptions = new HashSet<String>();
		boolean flag = false;
		for(WebElement Optionslist:listbox.getOptions())
		{
			String optionslistText = Optionslist.getText();
			
			if(!uniquelistoptions.add(optionslistText))
			{
				System.out.println("Duplicates Found :"+optionslistText);
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
