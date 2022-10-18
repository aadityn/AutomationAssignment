package com.cybage.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC007_DynamicProperties 
{
	public static WebDriver driver;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//span[contains(text(),'Dynamic Properties')]")).click();
		js.executeScript("window.scrollBy(0,-350)", "");
		
		//clicking on will enable after 5 seconds button
		WebElement ele1= driver.findElement(By.xpath("//button[@id='enableAfter']"));
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
		
		System.out.println("Check the Button is Enabled : " +ele1.isEnabled());
		
		//clicking on color change button 
		driver.findElement(By.id("colorChange")).click();
		
		//clicking on visible after 5 seconds 
		WebElement ele2=driver.findElement(By.id("visibleAfter"));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("visibleAfter"))));
		
		System.out.println("To check whether the Button is Displayed :" +ele2.isDisplayed());
		
		driver.close();
	}

}
