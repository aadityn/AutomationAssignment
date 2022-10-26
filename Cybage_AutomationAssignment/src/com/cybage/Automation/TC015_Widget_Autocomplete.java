package com.cybage.Automation;

import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC015_Widget_Autocomplete 
{
	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aadityn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/auto-complete");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TC015_Widget_Autocomplete complete= new TC015_Widget_Autocomplete();
		
		//Entering the Names in the Fields 
		complete.ColorFill("Black");
		
	//	driver.quit();

	}
	
	public void ColorFill(String textToSelect)
	{
		WebElement multiplecolor=driver.findElement(By.xpath("//span[contains(text(),'Type multiple color names')]/following-sibling::div/div/div[1]"));
		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(multiplecolor));
		
		List<WebElement> optionsToSelect = multiplecolor.findElements(By.tagName("div"));
		for(WebElement option : optionsToSelect){
	        if(option.getText().equals(textToSelect)) {
	        	System.out.println("Trying to select: "+textToSelect);
	            option.click();
	            break;
	
	}
	
}
