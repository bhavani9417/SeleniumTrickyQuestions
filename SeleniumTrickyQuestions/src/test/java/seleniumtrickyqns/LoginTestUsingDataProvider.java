package seleniumtrickyqns;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestUsingDataProvider {

	@Test(dataProvider ="loginData")
	public void loginTest(String email, String password) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/login");
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		boolean loginstatus;
		
		try {
		loginstatus = driver.findElement(By.xpath("//a[normalize-space()='Log out']")).isDisplayed();
		Assert.assertTrue(loginstatus);
		}catch(Exception e)
		{
			loginstatus=false;
			Assert.assertTrue(loginstatus);
		}
		finally {
			driver.quit();
		}
	}
	
	@DataProvider(parallel=true)
	public String[][] loginData(){
		
		String[][] data = {
				{"john.doe1234@example.com", "test123"},
				{"jane.smith321@example.com", "test321"},
				{"laura.taylor1234@example.com", "test123"},
				{"john.doe1234@example.com", "test123"},
				{"jane.smith321@example.com", "test321"},
				{"laura.taylor1234@example.com", "test123"}
		};
		return data;
	}
	

	
}
