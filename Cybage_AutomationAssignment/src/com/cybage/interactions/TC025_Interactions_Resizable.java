package com.cybage.interactions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TC025_Interactions_Resizable 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/resizable");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC025_Interactions_Resizable tt=new TC025_Interactions_Resizable();
				
		//scroll down to the desired element
		tt.Scroll();
		
		//clicking on tabs 
        WebElement resizeableElement = driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']/span"));
		resizable(resizeableElement, 200, 100);
		
		Thread.sleep(2000L);
		
		//closing the session
	//	driver.quit();
		
	}
	
	
	public static void resizable(WebElement elementToResize, int xOffset, int yOffset) 
	{
				try
				{
					Actions act= new Actions(driver);
					act.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
				}
				catch (StaleElementReferenceException e) 
				{
			            System.out.println("Element with " + elementToResize + "is not attached to the page document "  + e.getStackTrace());
			    }
				catch (NoSuchElementException e) 
				{
			            System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
			    } 
				catch (Exception e) 
				{
			            System.out.println("Unable to resize" + elementToResize + " - " + e.getStackTrace());
			    }
				
    }
	
	public void Scroll()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
}
