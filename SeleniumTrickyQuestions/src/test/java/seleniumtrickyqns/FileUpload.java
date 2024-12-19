package seleniumtrickyqns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.get("https://www.foundit.in/upload");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[contains(text(),'Upload Resume')]")).click();
		Thread.sleep(5000);
		
		//1. upload file using sendKeys() method
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("E:\\Workspace\\resources\\upload file.txt");
		
		System.out.println("File uploaded successfully");
		
		//2. upload file using Robot class
		driver.quit();

	}

}
