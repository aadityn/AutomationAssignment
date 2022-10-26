 package com.cybage.alertframewindows;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC010_Alerts 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\aadityn\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC010_Alerts alert= new TC010_Alerts();
		
		//clicking on Alert Button
		alert.alerthandling1();
		
		//clicking on 5 Seconds wait Alert
		alert.alert5sec();
		
		//clicking on Confirm
		alert.Confirm();
		
		//prompt alert
		alert.prompt();
		
		driver.quit();
			
	}
	
	public void alerthandling1() throws InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		WebElement alert1=driver.findElement(By.xpath("//button[@id='alertButton']"));
		wait.until(ExpectedConditions.elementToBeClickable(alert1)).click();
		
		Alert al= driver.switchTo().alert();
		al.accept();
		driver.switchTo().defaultContent();
		Thread.sleep(2000L);
	}
	
	public void alert5sec()
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		WebElement alert2=driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		wait.until(ExpectedConditions.elementToBeClickable(alert2)).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert al2= driver.switchTo().alert();
		al2.accept();
		driver.switchTo().defaultContent();
	}
	
	public void Confirm()
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		WebElement confirm=driver.findElement(By.xpath("//button[@id='confirmButton']"));
		wait.until(ExpectedConditions.elementToBeClickable(confirm)).click();
		
		Alert confirmalert= driver.switchTo().alert();
		confirmalert.dismiss();
		driver.switchTo().defaultContent();
	}
	
	public void prompt()
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		WebElement prompt=driver.findElement(By.xpath("//button[@id='promtButton']"));
		wait.until(ExpectedConditions.elementToBeClickable(prompt)).click();
		
		Alert promptalert= driver.switchTo().alert();
		promptalert.sendKeys("Aditya Nadkarni is my Name");
		promptalert.accept();
		driver.switchTo().defaultContent();
	}

}
