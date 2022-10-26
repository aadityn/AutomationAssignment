package com.cybage.interactions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC023_Interactions_Sortable 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/sortable");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC023_Interactions_Sortable tt=new TC023_Interactions_Sortable();
				
		//scroll down to the desired element
		tt.Scroll();
		
		//clicking on tabs 
		tt.sortables();
		
		//closing the session
		driver.quit();
		
	}
	
	
	public void sortables() throws InterruptedException
	{
		WebElement fromele1=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']/div[1]"));
		WebElement fromele2=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']/div[2]"));
		WebElement fromele3=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']/div[3]"));
		WebElement toele1=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']/div[4]"));
		WebElement toele2=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']/div[5]"));
		WebElement toele3=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']/div[6]"));
		
		Actions act= new Actions(driver);
		act.dragAndDrop(fromele1, toele1).build().perform();
		act.dragAndDrop(fromele2, toele2).build().perform();
		act.dragAndDrop(fromele3, toele3).build().perform();
	}
	
	public void Scroll()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
}
