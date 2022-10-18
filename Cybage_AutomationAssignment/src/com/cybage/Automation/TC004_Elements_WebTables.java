package com.cybage.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC004_Elements_WebTables 
{
	
	public static WebDriver driver;
	public static void main(String[] args) 
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[contains(text(),'Web Tables')]")).click();
		
		String BeforeXpath="//div[@class='rt-tbody']/div[";
		String AfterXpath="]/div/div[7]/div/span[2]";
		
		for(int i=0;i<10;i++)
		{
			if(driver.findElement(By.xpath("//div[@class='rt-tbody']")).getText().contains("Aditya"))
			{
					driver.findElement(By.xpath(BeforeXpath +i+AfterXpath)).click();
					break;
			}	
		}
		
		driver.findElement(By.id("addNewRecordButton")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Aditya");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Nadkarni");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("aadityn@cybage.com");
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("31");
		driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("29746");
		driver.findElement(By.xpath("//input[@id='department']")).sendKeys("QA Analyst");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
			
		
		if(driver.findElement(By.xpath("//div[@class='rt-tbody']")).getText().contains("Aditya"))
		{
			System.out.println("The Details were successfully entered in the Web table");
		}
		else
		{
			System.out.println("Please do Click on add button and enter the details again");
		}
		driver.close();
		
	}

}
