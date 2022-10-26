package com.cybage.widgets;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC020_Widgets_tooltips 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC020_Widgets_tooltips tt=new TC020_Widgets_tooltips();
				
		//scroll down to the desired element
		tt.Scroll();
		
		//clicking on tabs 
		tt.hovers();
		
		//closing the session
		driver.quit();
		
	}
	
	
	public void hovers()
	{
		WebElement hover1=driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		Actions act=new Actions(driver);
		act.moveToElement(hover1).build().perform();
		System.out.println("The text when you hover on Button is : " +driver.findElement(By.xpath("//div[@id='buttonToolTip']/div[2]")).getText());
		
		WebElement hover2=driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
		act.moveToElement(hover2).build().perform();
		System.out.println("The text when you hover on Textfield is : " +driver.findElement(By.xpath("//div[@id='textFieldToolTip']/div[2]")).getText());
	
	}
	
	public void Scroll()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
}
