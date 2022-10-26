 package com.cybage.alertframewindows;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC012_NestedFrames 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC012_NestedFrames nestedframes= new TC012_NestedFrames();
		
		//scrolling down to desired location
		nestedframes.Scrolldown();
		
		//handling Frames
		nestedframes.HandlingNestedFrames();
				
		driver.quit();
			
	}
	
	public void HandlingNestedFrames() throws InterruptedException
	{
		 WebElement frame1=driver.findElement(By.id("frame1"));
		 driver.switchTo().frame(frame1);
		 System.out.println("The content inside Frame 1 is : " +driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]")).getText());
		 
		 WebElement frame2=driver.findElement(By.cssSelector("[srcdoc='\\<p\\>Child Iframe\\<\\/p\\>']"));
		 driver.switchTo().frame(frame2);
		 System.out.println("The content inside Frame 2 is : " +driver.findElement(By.xpath("//body/p[contains(text(),'Child Iframe')]")).getText());
		 
		 driver.switchTo().defaultContent();
	}
	
	public void Scrolldown()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
	
	

}
