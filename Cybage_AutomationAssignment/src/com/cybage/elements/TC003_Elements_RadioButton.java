package com.cybage.elements;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC003_Elements_RadioButton
{

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]")).click();
		
		
		WebElement radio=driver.findElement(By.xpath("//input[@id='yesRadio']"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", radio);
		
		if(driver.findElement(By.xpath("//p[@class='mt-3']")).getText().contains("Yes"))
		{
			System.out.println("Radio was clicked Successfully");
		}
		else
		{
			System.out.println("Radio button was not clicked");
		}
		
		driver.close();

	}

}
