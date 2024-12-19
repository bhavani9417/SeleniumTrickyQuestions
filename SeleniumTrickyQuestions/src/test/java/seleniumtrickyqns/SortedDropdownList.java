package seleniumtrickyqns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class SortedDropdownList {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//here we are taking sorted list box
		Select listboxoptions = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		
		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> templist = new ArrayList<String>();
		
		List<WebElement> list = listboxoptions.getOptions();
		for(WebElement options:list)
		{
			originalList.add(options.getText());
			templist.add(options.getText());
		}
		System.out.println("Before Sorting the list");
		System.out.println("Original List"+originalList);
		System.out.println("Temporary List"+templist);
		Collections.sort(templist);
		System.out.println("After Sorting the list");
		System.out.println("Original List"+originalList);
		System.out.println("Temporary List"+templist);
		
		if(originalList.equals(templist))
		{
			System.out.println("List box is sorted");
		}
		else
		{
			System.out.println("List box is not sorted");
		}
		driver.quit();
	}

}
