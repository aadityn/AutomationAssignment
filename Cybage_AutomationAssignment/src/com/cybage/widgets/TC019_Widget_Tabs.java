package com.cybage.widgets;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC019_Widget_Tabs 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/tabs");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC019_Widget_Tabs tt=new TC019_Widget_Tabs();
				
		//scroll down to the desired element
		tt.Scroll();
		
		//clicking on tabs 
		tt.tabs();
		
		//closing the session
		driver.quit();
		
	}
	
	
	public void tabs()
	{
		WebElement tab1=driver.findElement(By.xpath("//a[@id='demo-tab-origin']"));
		tab1.click();
		System.out.println("The content inside " +tab1.getText()+" is :" +driver.findElement(By.xpath("//div[@id='demo-tabpane-origin']")).getText());
		
		WebElement tab2=driver.findElement(By.xpath("//a[@id='demo-tab-use']"));
		tab2.click();
		System.out.println("The content inside " +tab2.getText()+ " is : " +driver.findElement(By.xpath("//div[@id='demo-tabpane-use']")).getText());
	}
	
	public void Scroll()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
}
