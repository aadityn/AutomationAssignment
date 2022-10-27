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


public class TC027_Interactions_Draggable 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/dragabble");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC027_Interactions_Draggable dg=new TC027_Interactions_Draggable();
				
		//scroll down to the desired element
		dg.Scroll();
		
		//clicking on tabs 
		dg.draggable();
        Thread.sleep(2000L);
        
		//closing the session
		driver.quit();
		
	}
	
	
	public void draggable() 
	{
		
			driver.findElement(By.xpath("//a[@id='draggableExample-tab-cursorStyle']")).click();
			WebElement ele1= driver.findElement(By.xpath("//div[@id='cursorCenter']"));
			WebElement ele2=driver.findElement(By.xpath("//div[@id='cursorTopLeft']"));
			WebElement ele3=driver.findElement(By.xpath("//div[@id='cursorBottom']"));
			
			Actions act= new Actions(driver);
			act.dragAndDropBy(ele1, 200, 50).build().perform();
			act.dragAndDropBy(ele2, 400, 50).build().perform();
			act.dragAndDropBy(ele3, 600, 50).build().perform();
			System.out.println("Dragged successfully");
				
    }
	
	public void Scroll()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
}
