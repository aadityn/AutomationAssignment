package com.cybage.widgets;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;


public class TC015_Widget_Autocomplete 
{
	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\aadityn\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/auto-complete");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		TC015_Widget_Autocomplete twa= new TC015_Widget_Autocomplete();
		twa.autocomplete();
		
	//	driver.quit();
		
		
	}
	
	public void autocomplete()
	{
		WebElement ele1=driver.findElement(By.xpath("//div[@id='autoCompleteMultipleContainer']"));
		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele1));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele1);
		ele1.sendKeys("a");
		
		SelectOption("Black");
		
		
	}
	
	public void SelectOption(String color)
	{
		try 
		{
			WebElement Multichoice = driver.findElement(By.cssSelector(".auto-complete__value-container.auto-complete__value-container--is-multi.auto-complete__value-container--has-value.css-1hwfws3"));
			
			WebDriverWait wait= new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(Multichoice));

			List<WebElement> optionsToSelect = Multichoice.findElements
			(By.xpath("//div[@class='auto-complete__value-container auto-complete__value-container--is-multi auto-complete__value-container--has-value css-1hwfws3']/div"));
			for(WebElement option : optionsToSelect)
			{
		        if(option.getText().equals(color)) 
		        {
		        	System.out.println("Trying to select: "+color);
		            option.click();
		            break;
		        }
		    }
		}
		catch (NoSuchElementException e) 
		{
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) 
		{
			System.out.println(e.getStackTrace());
		}
	}
}

