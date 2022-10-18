package com.cybage.Automation;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC006_DownloadUpload 
{
	public static WebDriver driver;
	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//span[contains(text(),'Upload and Download')]")).click();
		
		js.executeScript("window.scrollBy(0,-250)", "");
		
		Thread.sleep(2000L);
		
		WebElement uploadElement = driver.findElement(By.id("uploadFile"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\aadityn\\Downloads\\sampleFile.jpeg");

        driver.close();
	}

}
