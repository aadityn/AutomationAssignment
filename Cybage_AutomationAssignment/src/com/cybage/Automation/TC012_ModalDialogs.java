package com.cybage.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC012_ModalDialogs 
{
	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/modal-dialogs");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TC012_ModalDialogs tc= new TC012_ModalDialogs();
		
		//clicking on Small Modal Button
		tc.smallmodal();
		
		Thread.sleep(2000L);
		
		//Clicking on Large Modal Button 
		tc.largeModal();
		
		driver.quit();

	}
	
	public void smallmodal()
	{
		driver.findElement(By.xpath("//button[@id='showSmallModal']")).click();
		
		WebElement closeModal=driver.findElement(By.xpath("//button[@id='closeSmallModal']"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(closeModal));
		
		System.out.println("The text inside the Small Modal is : " +driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
		closeModal.click();
	}
	
	public void largeModal()
	{
		driver.findElement(By.xpath("//button[@id='showLargeModal']")).click();
		
		WebElement closeLargeModal=driver.findElement(By.xpath("//button[@id='closeLargeModal']"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(closeLargeModal));
		
		System.out.println("The text inside the Large Modal is : " +driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
		closeLargeModal.click();
	}

}
