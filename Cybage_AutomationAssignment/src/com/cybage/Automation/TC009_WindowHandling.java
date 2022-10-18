 package com.cybage.Automation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC009_WindowHandling 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC009_WindowHandling windows= new TC009_WindowHandling();
		
		//handling New Tab
	//	windows.HandlingnewTab();
		
		//handling new Window
	//	windows.newWindow();
		
		//handling new Window with Long message
		windows.NewWindowMsg();
				
		driver.quit();
			
	}
	
	public void HandlingnewTab() throws InterruptedException
	{	
		String currentWindow= driver.getWindowHandle();
		System.out.println(currentWindow);
		
		driver.findElement(By.xpath("//button[@id='tabButton']")).click();
		
		Set<String> allwindowshandles=driver.getWindowHandles();
		System.out.println(allwindowshandles);
		 Iterator<String> iterator = allwindowshandles.iterator();
		 
		 while(iterator.hasNext())
		 {
			 String childwindow=iterator.next();
			 {
				 if(!currentWindow.contentEquals(childwindow))
				 {
					 	driver.switchTo().window(childwindow);
		                WebElement text = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		                System.out.println("Heading of child window in New Tab is : " + text.getText());
		                driver.close();
		                driver.switchTo().window(currentWindow);
				 }
			 }
		 }
		
	}
	
	public void newWindow()
	{
		//Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
                
        WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("windowButton")))).click();
		
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) 
        {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow))
                {
	                driver.switchTo().window(ChildWindow);
	                WebElement text = driver.findElement(By.id("sampleHeading"));
	                System.out.println("Heading of child window in New Window is : " + text.getText());
	                driver.close();
	                driver.switchTo().window(mainWindowHandle);
                }
        }
	}
	
	public void NewWindowMsg()
	{
		//Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
                
        WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("messageWindowButton")))).click();
		
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) 
        {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow))
                {
	                driver.switchTo().window(ChildWindow);
	                WebElement text = driver.findElement(By.xpath("/html/body"));
	                System.out.println("Heading of child window in New Window is : " + text.getText());
	                driver.close();
	                driver.switchTo().window(mainWindowHandle);
                }
		}
	}
}
