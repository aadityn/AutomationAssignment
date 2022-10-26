 package com.cybage.alertframewindows;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC011_Frames 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC011_Frames frames= new TC011_Frames();
		
		//scrolling down to desired location
		frames.Scrolldown();
		
		//handling Frames
		frames.HandlingFrames();
				
		driver.quit();
			
	}
	
	public void HandlingFrames() throws InterruptedException
	{
		driver.switchTo().frame("frame1");
		System.out.println("The content from the first Frame is :" +driver.findElement(By.xpath("//h1[contains(text(),'This is a sample page')]"))
		.getText());
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		System.out.println("The content from 2nd Frame is : " +driver.findElement(By.xpath("//h1[contains(text(),'This is a sample page')]"))
		.getText());
		driver.switchTo().defaultContent();
	}
	
	public void Scrolldown()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
	
	

}
