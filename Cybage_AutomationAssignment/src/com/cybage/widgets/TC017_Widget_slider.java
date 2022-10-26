package com.cybage.widgets;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC017_Widget_slider 
{
	public static WebDriver driver;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/slider");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement pos= driver.findElement(By.id("sliderValue"));
		System.out.println("The Position before movement was :" +pos.getAttribute("value"));
		
		WebElement draganddrop=driver.findElement(By.xpath("//input[@type='range']"));
		
		Actions act= new Actions(driver);
		act.dragAndDropBy(draganddrop, 153, 0).build().perform();
		System.out.println("The Position After movement is :" +pos.getAttribute("value"));
		
		driver.quit();
	}

}
