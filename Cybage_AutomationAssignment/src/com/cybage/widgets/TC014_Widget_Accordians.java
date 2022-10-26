package com.cybage.widgets;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC014_Widget_Accordians 
{
	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/accordian");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TC014_Widget_Accordians accords= new TC014_Widget_Accordians();
		
		//scrolling down because of Advertisements
		accords.scrolldown();
		
		//Clicking on Accordians
		accords.AccordsClick();
		
		driver.quit();

	}
	
	public void AccordsClick()
	{
		driver.findElement(By.xpath("//div[@id='section1Heading']")).click();
		driver.findElement(By.xpath("//div[@id='section2Heading']")).click();
		
		System.out.println("The text inside the 2nd Accordian is : " + driver.findElement(By.xpath("//div[@id='section2Heading']/following-sibling::div/div")).getText());
		driver.findElement(By.xpath("//div[@id='section2Heading']")).click();
		
		WebElement thirdcontent=driver.findElement(By.xpath("//div[@id='section3Heading']"));
		thirdcontent.click();
		System.out.println("The content inside " +thirdcontent.getText()+ " is :" +driver.findElement(By.xpath("//div[@id='section3Content']")).getText());
		
		
		
	}
	
	public void scrolldown()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)", "");
	}
	
}
