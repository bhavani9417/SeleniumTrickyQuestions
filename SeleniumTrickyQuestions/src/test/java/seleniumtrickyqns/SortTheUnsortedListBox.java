package seleniumtrickyqns;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class SortTheUnsortedListBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Select listbox=new Select(driver.findElement(By.xpath("//select[@id='country']")));
		
		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> tempList = new ArrayList<String>();
		
		List<WebElement> listboxoptions=listbox.getOptions();
		
		for(WebElement option:listboxoptions)
		{
			originalList.add(option.getText());
			tempList.add(option.getText());
		}

		System.out.println("Before Sorting the list");
		System.out.println("Original List"+originalList);
		System.out.println("Temporary List"+tempList);
		Collections.sort(tempList);
		System.out.println("After Sorting the list");
		System.out.println("Original List"+originalList);
		System.out.println("Temporary List"+tempList);
		
		if(originalList.equals(tempList))
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
