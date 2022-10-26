package com.cybage.elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC005_Elements_Buttons 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement btnmain=driver.findElement(By.xpath("//span[contains(text(),'Buttons')]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", btnmain);
		
		Thread.sleep(2000L);
		
		//scrolling down the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		
		Actions act= new Actions(driver);
		WebElement dblclick= driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		act.doubleClick(dblclick).build().perform();
		
		
		WebElement rgtclick=driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		act.contextClick(rgtclick).perform();
		
		
		driver.findElement(By.xpath("//button[@id='rightClickBtn']/parent::div/following-sibling::div/button")).click();
		
		driver.close();
	}

}
