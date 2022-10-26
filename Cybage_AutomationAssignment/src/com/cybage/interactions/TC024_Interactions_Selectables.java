package com.cybage.interactions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC024_Interactions_Selectables 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/selectable");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC024_Interactions_Selectables tt=new TC024_Interactions_Selectables();
				
		//scroll down to the desired element
		tt.Scroll();
		
		//clicking on tabs 
		tt.selectables();
		
		Thread.sleep(2000L);
		
		//closing the session
		driver.quit();
		
	}
	
	
	public void selectables() throws InterruptedException
	{
		driver.findElement(By.id("demo-tab-grid")).click();
		
		Thread.sleep(2000L);
		
		WebElement ele1= driver.findElement(By.xpath("//div[@id='row1']/li[1]"));
		WebElement ele2=driver.findElement(By.xpath("//div[@id='row2']/li[2]"));
		WebElement ele3=driver.findElement(By.xpath("//div[@id='row3']/li[3]"));
		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele1));
		
		ele1.click();
		ele2.click();
		ele3.click();
		
	}
	
	public void Scroll()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
}
