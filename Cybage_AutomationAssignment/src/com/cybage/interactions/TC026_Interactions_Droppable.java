package com.cybage.interactions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC026_Interactions_Droppable 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC026_Interactions_Droppable dd=new TC026_Interactions_Droppable();
				
		//scroll down to the desired element
		dd.Scroll();
		
		//clicking on tabs 
        dd.droppable();
        Thread.sleep(2000L);
        
        //clicking on accept tab
        dd.droppable1();
		Thread.sleep(2000L);
		
		//closing the session
		driver.quit();
		
	}
	
	
	public void droppable() 
	{
			WebElement fromele1= driver.findElement(By.xpath("//div[@id='draggable']"));
			WebElement toele1=driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']/div/div[2]"));
			
			Actions act= new Actions(driver);
			act.dragAndDrop(fromele1, toele1).build().perform();
			System.out.println("Dragged successfully");
				
    }
	
	public void droppable1() 
	{
			driver.findElement(By.id("droppableExample-tab-accept")).click();
			
			WebElement fromele1= driver.findElement(By.xpath("//div[@id='acceptable']"));
			WebElement fromele2= driver.findElement(By.xpath("//div[@id='notAcceptable']"));
			WebElement toele1=driver.findElement(By.xpath("//div[@class='accept-drop-container']/div[2]"));
			
			WebDriverWait wait= new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(fromele2));
			
			
			Actions act= new Actions(driver);
			act.dragAndDrop(fromele2, toele1).build().perform();
			act.dragAndDrop(fromele1, toele1).build().perform();
			System.out.println("Both Dragged successfully ");
				
    }
	
	public void Scroll()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
}
