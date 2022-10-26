package com.cybage.widgets;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC021_Widgets_Menus 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC021_Widgets_Menus tt=new TC021_Widgets_Menus();
				
		//scroll down to the desired element
		tt.Scroll();
		
		//clicking on tabs 
		tt.Menus();
		
		//closing the session
		driver.quit();
		
	}
	
	
	public void Menus() throws InterruptedException
	{
		WebElement hover1=driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));
		Actions act=new Actions(driver);
		act.moveToElement(hover1).build().perform();
		
		
		WebElement hover2=driver.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"));
		act.moveToElement(hover2).build().perform();
		
		WebElement hover3=driver.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 1')]"));
		act.moveToElement(hover3).build().perform();
		
		Thread.sleep(3000L);
	
	
	}
	
	public void Scroll()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
}
