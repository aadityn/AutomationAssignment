package com.cybage.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC001_Elements_Textbox 
{

	public static WebDriver driver;
	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();
		
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Aditya Nadkarni");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("aadityn@cybage.com");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("CT 1, Kalyani Nagar, Pune");
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Mumbai");
		
		//scrolling down the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		//To check whether submit button was really pressed.
		if(driver.findElement(By.xpath("//button[@id='submit']/parent::div/parent::div/following-sibling::div/div/p[1]")).getText().contains("Aditya Nadkarni"))
		{
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");
		}
		
		driver.close();
		

	}

}
