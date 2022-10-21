package com.cybage.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC018_Widget_Progressbar 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/progress-bar");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement startbtn= driver.findElement(By.xpath("//button[@id='startStopButton']"));
		startbtn.click();
		
		for(int i=0;i<=30;i++)
		{
			if(driver.findElement(By.xpath("//div[contains(@class,'progress-bar bg-success')]"))!=null)
			{
				System.out.println("Your progress is completed :" +driver.findElement(By.xpath("//div[@role='progressbar']")).getText());
				driver.findElement(By.xpath("//button[@id='resetButton']")).click();
			}
			
		}
	}
}
