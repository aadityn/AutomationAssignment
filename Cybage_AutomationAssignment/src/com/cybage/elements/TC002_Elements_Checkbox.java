package com.cybage.elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002_Elements_Checkbox 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/elements");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
			
			//scrolling down the page
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)", "");
			
			driver.findElement(By.xpath("//button[@title='Expand all']")).click();
			
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//span[contains(text(),'Documents')]/preceding-sibling::span[2]")).click();
				
			driver.findElement(By.xpath("//span[contains(text(),'Veu')]")).click();
			
			driver.findElement(By.xpath("//span[contains(text(),'Classified')]")).click();
			
			//scrolling down the page
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,350)", "");
			
			if(driver.findElement(By.xpath("//div[@id='result']")).getText().contains("angular"))
			{
				System.out.println("Check box clicked successfully");
			}
			else
			{
				System.out.println("Check box was not clicked");
			}
			
			driver.close();

	}

}
